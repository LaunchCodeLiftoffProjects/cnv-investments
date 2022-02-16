package com.liftoff.cnvInvestments.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liftoff.cnvInvestments.models.QuoteResponse;
import com.liftoff.cnvInvestments.models.QuoteResponseWrapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Component
public class YahooClient {



    @PostConstruct
    public Object contextRefreshEvents() {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://yfapi.net/v6/finance/quote?symbols=AAPL"))
                .headers("x-api-key","LjeohuFbQL6PugNM8EWOR5YgU3PqRzZB4BNfzJwg")
                .build();

        HttpResponse<String> response;

        {
            try {

                ObjectMapper mapper = new ObjectMapper();


                response = client.send(request, HttpResponse.BodyHandlers.ofString());


                QuoteResponseWrapper quoteResponseWrapper = mapper.readValue(response.body(), QuoteResponseWrapper.class);
                System.out.println(quoteResponseWrapper.getQuoteResponse().getResult().get(0).getRegularMarketPrice());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public CompletableFuture<Map<String,String>> JSONBodyAsMap(URI uri) {
        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Accept", "application/json")
                .build();

        return HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(objectMapper::readValue);
    }

    class UncheckedObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
        /**
         * Parses the given JSON string into a Map.
         */
        Map<String, String> readValue(String content) {
            try {
                return this.readValue(content, new TypeReference<>() {
                });
            } catch (IOException ioe) {
                throw new CompletionException(ioe);
            }
        }
    }

    public CompletableFuture<Void> postJSON(URI uri,
                                            Map<String,String> map)
            throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(System.out::println);
    }





}
