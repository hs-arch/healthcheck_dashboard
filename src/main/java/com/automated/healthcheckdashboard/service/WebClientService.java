package com.automated.healthcheckdashboard.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class WebClientService {

    private final WebClient webClient;


    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = WebClient.builder().build();
    }


    public String checkUrlStatus(String url){
        System.out.println("Attempting to check the url...");

        try{

//            this.webClient.head()
//                    .uri(url)
//                    .retrieve()
//                    .toBodilessEntity()
//                    .block();

            ResponseEntity<Void> response = this.webClient.get().uri(url).retrieve().toBodilessEntity().block();

            System.out.println("URL is UP. Status: 2xx Success");
            System.out.println("Status : " + response.getStatusCode());

            return response.getStatusCode().toString();

        }catch(WebClientResponseException e){
            System.out.println("URL is down. Status : " + e.getStatusCode());
            return "DOWN";
        }catch(Exception e){
            System.out.println("GEneric error");
            return "DOWN";
        }
    }
}
