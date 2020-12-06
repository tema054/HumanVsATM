package ru.sber.projectATM.core.bank.accounting;

import lombok.Setter;
import lombok.ToString;
import ru.sber.projectATM.core.handbook.Status;

@ToString
@Setter
public class BalanceResponse {
    private Balance balance;
    private Status RC;
}
