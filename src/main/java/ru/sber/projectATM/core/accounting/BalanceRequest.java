package ru.sber.projectATM.core.accounting;

import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
public class BalanceRequest {

    private Balance balance;
    private String RC;

}
