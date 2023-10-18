from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from datetime import datetime, timedelta
from typing import List, Optional

app = FastAPI()

# Sample data: users, incidents, and communities
users = {}
incidents = []
communities = {}

class User(BaseModel):
    username: str
    trust_points: float = 5
    last_update: Optional[datetime] = None
    incidents_opened_this_week: int = 0
    incidents_closed_this_week: int = 0
    trust_level: Optional[str] = None

class Incident(BaseModel):
    opened_by: str
    opened_at: datetime
    closed_at: Optional[datetime] = None

class Community(BaseModel):
    name: str
    users: List[str]

# Calculate trust level
def calculate_user_trust_level(user):
    if user.trust_points < 2:
        user.trust_level = "No confiable"
    elif 2 <= user.trust_points <= 3:
        user.trust_level = "Con reservas"
    elif 3 <= user.trust_points <= 5:
        user.trust_level = "Confiable Nivel 1"
    else:
        user.trust_level = "Confiable Nivel 2"

def calculate_community_trust_level(community):
    total_points = sum(users[user].trust_points for user in community.users)
    for user in community.users:
        if users[user].trust_level == "Con reservas":
            total_points -= 0.2
    average_points = total_points / len(community.users)
    community.trust_level = "No confiable" if average_points < 2 else "Con reservas" if average_points < 3 else "Confiable Nivel 1" if average_points < 5 else "Confiable Nivel 2"

# Endpoint to open an incident
@app.post("/open_incident/")
def open_incident(username: str):
    if username not in users:
        raise HTTPException(status_code=404, detail="User not found")
    
    user = users[username]
    now = datetime.now()

    if user.last_update is None:
        user.last_update = now

    if (now - user.last_update).total_seconds() < 3 * 60:
        user.trust_points -= 0.2

    user.incidents_opened_this_week += 1
    user.last_update = now
    calculate_user_trust_level(user)
    incidents.append(Incident(opened_by=username, opened_at=now))
    return {"message": "Incident opened successfully."}

# Endpoint to close an incident
@app.post("/close_incident/")
def close_incident(username: str):
    if username not in users:
        raise HTTPException(status_code=404, detail="User not found")
    
    user = users[username]
    now = datetime.now()

    if user.last_update is None:
        user.last_update = now

    if (now - user.last_update).total_seconds() < 3 * 60:
        user.trust_points -= 0.2

    user.incidents_closed_this_week += 1
    user.last_update = now
    calculate_user_trust_level(user)

    # Check if there's a recently opened incident by another user
    for incident in incidents:
        if (now - incident.opened_at).total_seconds() < 3 * 60 and incident.opened_by != username:
            user.trust_points -= 0.2

    calculate_user_trust_level(user)
    return {"message": "Incident closed successfully."}

# Endpoint to update trust levels
@app.post("/update_trust_levels/")
def update_trust_levels():
    today = datetime.now()
    # Check if it's Sunday at 13:00 (for demonstration purposes, you can adjust this time)
    if today.weekday() == 6 and today.hour == 13:
        for username, user in users.items():
            user.trust_points += 0.5 * (user.incidents_opened_this_week + user.incidents_closed_this_week)
            user.incidents_opened_this_week = 0
            user.incidents_closed_this_week = 0
            calculate_user_trust_level(user)

        for community in communities.values():
            calculate_community_trust_level(community)

        return {"message": "Trust levels updated successfully."}

# Inactivate users and communities
@app.post("/inactivate_users_and_communities/")
def inactivate_users_and_communities():
    to_inactivate_users = [username for username, user in users.items() if user.trust_level == "No confiable"]
    for username in to_inactivate_users:
        users.pop(username)

    for community in communities.values():
        to_remove_users = [username for username in community.users if username in to_inactivate_users]
        community.users = [username for username in community.users if username not in to_inactivate_users]

    return {"message": "Users and communities inactivated."}

@app.get("/user/{username}", response_model=User)
def get_user(username: str):
    if username not in users:
        raise HTTPException(status_code=404, detail="User not found")
    return users[username]

@app.post("/create_user/")
def create_user(user: User):
    if user.username in users:
        raise HTTPException(status_code=400, detail="User already exists")
    
    users[user.username] = user
    return {"message": "User created successfully."}


if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)

