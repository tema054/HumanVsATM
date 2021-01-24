package ru.sber.projectATM.AutomatedTellerMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import ru.sber.projectATM.common.Balance;
import ru.sber.projectATM.common.handbook.*;


@Getter
@ToString
@AllArgsConstructor
public class BalanceDTO {
    @NonNull
    private Balance amount;
    @NonNull
    private Status currency;


}
