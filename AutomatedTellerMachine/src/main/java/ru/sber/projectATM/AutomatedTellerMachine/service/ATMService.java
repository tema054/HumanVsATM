package ru.sber.projectATM.AutomatedTellerMachine.service;

import org.springframework.stereotype.Service;
import ru.sber.projectATM.AutomatedTellerMachine.dto.BalanceDTO;


@Service
public class ATMService {

    public BalanceDTO getClientBalance(Long clientId, Long accountId, int PIN) {
        return new BalanceDTO();
    }
}
