package Domain.mailpro;
import java.net.http.*;
import java.io.IOException;
import java.net.URI;

public class ApiAuthentication {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("API Authentication Sample");
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.mailpro.com/v3/token"))
        .header("accept", "application/json")
        .header("content-type", "application/json")
        .method("POST", HttpRequest.BodyPublishers.ofString("grant_type=password&username=fdalsasso@frba.utn.edu.ar&password=c648b40f-4a4e-4f8a-b34a-efddca7ff177"))
        .build();
    HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  }
}


