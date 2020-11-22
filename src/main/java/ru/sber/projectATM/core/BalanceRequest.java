package ru.sber.projectATM.core;

import lombok.Setter;
import lombok.ToString;
import ru.sber.projectATM.core.helperСlass.Handbook.*;


@ToString
public class BalanceRequest {

    @Setter
    private Double availableAmount;
    @Setter
    private Currency currency;
    @Setter
    private String responseСode;
    @Setter
    private Status status;


}
