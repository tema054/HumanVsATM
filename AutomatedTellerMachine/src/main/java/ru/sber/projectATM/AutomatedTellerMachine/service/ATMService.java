package ru.sber.projectATM.AutomatedTellerMachine.service;

import org.springframework.stereotype.Service;
import ru.sber.projectATM.AutomatedTellerMachine.dto.BalanceDTO;
import ru.sber.projectATM.common.Balance;
import ru.sber.projectATM.common.handbook.Status;


@Service
public class ATMService {

    public BalanceDTO getClientBalance(Balance balance, Status status) {

        return new BalanceDTO(balance, status);
    }
}
