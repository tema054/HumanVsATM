package ru.sber.projectATM.AutomatedTellerMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import ru.sber.projectATM.common.handbook.*;


@Getter
@ToString
public class BalanceDTO {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;
}
