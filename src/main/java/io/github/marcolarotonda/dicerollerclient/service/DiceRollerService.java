package io.github.marcolarotonda.dicerollerclient.service;

import io.github.marcolarotonda.dicerollerutil.model.RollResult;
import io.github.marcolarotonda.dicerollerutil.model.RollOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DiceRollerService {

    private final DiceRollerClientService diceRollerClientService;

    @Autowired
    public DiceRollerService(DiceRollerClientService diceRollerClientService) {
        this.diceRollerClientService = diceRollerClientService;
    }

    public RollResult roll(@RequestParam RollOption rollOption) {
        return diceRollerClientService.getResult(rollOption);
    }
}
