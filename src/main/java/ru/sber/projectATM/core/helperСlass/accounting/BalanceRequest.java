package ru.sber.projectATM.core.helperСlass.accounting;

import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
public class BalanceRequest {


    private Double availableAmount;
    private Currency currency;
    private String responseСode;
    private Status status;


}
