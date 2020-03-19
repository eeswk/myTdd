package chap09;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class CardNumberValidator {
    private String server;

    public CardNumberValidator(String server) {
        this.server = server;
    }

    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        //applicatioin/json
        //String data = "{\"cardNumber\":" + cardNumber +"}";
        System.out.println(cardNumber);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(server+ "/card"))
                .header("Content-Type", "text/plain")
                .POST(BodyPublishers.ofString(cardNumber))
//                .header("Content-Type", "application/json")
  //              .POST(HttpRequest.BodyPublishers.ofString(data))
                .timeout(Duration.ofSeconds(3))
                .build();

        try {
            System.out.println(request.bodyPublisher());
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            switch (response.body()) {
                case "ok": return CardValidity.VALID;
                case "bad": return CardValidity.INVALID;
                case "expired": return CardValidity.EXPIRED;
                case "theft": return CardValidity.THEFT;
                default: return CardValidity.UNKONWN;

            }
        } catch (HttpTimeoutException e) {
            return CardValidity.TIMEOUT;
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }

    public static void main(String[] args) {
        CardNumberValidator test = new CardNumberValidator("http://localhost:3000");
        System.out.println(test.validate("1234"));
    }
}
