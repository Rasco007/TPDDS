# Endpoints of API

* Entidades 
	* Usario
	* Incidente 

## GET 

> Obtener datos 

### Usuario 

* /user/{user_ID}
* Estados 
	* 200 -> OK
	* 400 -> Invalidid ID
	* 404 -> user not foundf

```
{
  "id": 0,  
  "username": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "puntos":float,
  "status": "available"
}
```
* /incidente/{incident_ID}
* Estados 
	* 200 -> OK
	* 400 -> Invalidid ID
	* 404 -> Incident not found
* status
	* open 
	* close 

```
{
  "id": 0,    
  "status": "string",
  "description": [
		"description": String
		"openby" : user
		"closeby": user
	],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
}

```
## POST 

> Creacion de datos 

* /user/
* /user/{incident\_ID}/incidente

```
{
  "id": 1,    
  "status": "active",
  "description": [
		"description": "El ascensor no funciona bien"
		"openby" : "pepe"
		"closeby": "none"
	],
  "tags": [
    {
      "id": 3,
      "name": "Subte D"
    }
}
```

## DELETE

> Eliminar 

* /user/{user\_ID}
* Estados 
	* 200 -> OK
	* 400 -> Invalid ID
	* 404 -> user not found
	
* /incident/{incident_ID}
* Estados 
	* 200 -> OK
	* 400 -> Invalidid ID
	* 404 -> user not found

## PUT 

> Actualizacion 

* /incident
* Responses 
	* 400 -> Invalid ID
	* 404 -> Incident not found 
	* 405 -> Vladation exception

```
{
  "id": 1,    
  "status": "active",
  "description": [
		"description": "El ascensor no funciona bien"
		"openby" : "pepe"
		"closeby": "Juan"
	],
  "tags": [
    {
      "id": 3,
      "name": "Subte D"
    }
}
```

* /user 
* Responses 
	* 400 -> Invalid ID
	* 404 -> user not found 
	* 405 -> Vladation exception

