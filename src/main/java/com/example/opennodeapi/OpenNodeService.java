package com.example.opennodeapi;

import com.example.opennodeapi.models.*;
import com.example.opennodeapi.models.OpenNodeChangeInfoList.OpenNodeChargeData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OpenNodeService {
    private final String apiKey;
    private final String readKey;
    private final WebClient webClient;

    public OpenNodeService(@Value("${open.node.key}") String apiKey, @Value("${open.node.read_key}") String readKey) {
        this.apiKey = apiKey;
        this.readKey = readKey;
        this.webClient = WebClient.builder()
                .baseUrl("https://api.opennode.com")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("accept", "application/json")
                .defaultHeader("Authorization", apiKey)
                .build();
    }
    public OpenNodeChargeResponse createCharge(OpenNodeCreateCharge charge) {
        return webClient
                .post()
                .uri("/v1/charges/")
                .body(BodyInserters.fromValue(charge))
                .retrieve()
                .bodyToMono(OpenNodeChargeResponse.class)
                .block();
    }

    public OpenNodeChargeInfo getCharge(String id) {
        return webClient
                .get()
                .uri("/v2/charge/{id}", id)
                .retrieve()
                .bodyToMono(OpenNodeChargeInfo.class)
                .block();
    }

    public List<OpenNodeChargeData> listPaidCharges() {
        OpenNodeChangeInfoList data = webClient
                .get()
                .uri("/v2/charges/")
                .header("Authorization", readKey)
                .retrieve()
                .bodyToMono(OpenNodeChangeInfoList.class)
                .block();
        return (data != null) ? data.getData().getItems() : List.of();
    }
}
