package io.github.marcolarotonda.dicerollerclient.service;

import io.github.marcolarotonda.dicerollerutil.model.RollResult;
import io.github.marcolarotonda.dicerollerutil.model.RollOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class DiceRollerClientService {

    private final RestClient restClient;

    DiceRollerClientService(@Value("${dice-roller-client.server-base-url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    RollResult getResult(RollOption rollOption) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/roll")
                        .queryParam("diceType", rollOption.getDiceType())
                        .queryParam("quantity", rollOption.getQuantity())
                        .queryParam("modifier", rollOption.getModifier())
                        .queryParam("merit", rollOption.isMerit())
                        .queryParam("rollType", rollOption.getRollType())
                        .build())
                .header("Content-Type", "application/json")
                .retrieve()
                .toEntity(RollResult.class)
                .getBody();
    }


}
