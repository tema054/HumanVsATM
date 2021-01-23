package ru.sber.projectATM.common;

import lombok.Setter;
import lombok.ToString;
import ru.sber.projectATM.common.handbook.Status;

@ToString
@Setter
public class BalanceResponse {
    private Balance balance;
    private Status RC;
}
