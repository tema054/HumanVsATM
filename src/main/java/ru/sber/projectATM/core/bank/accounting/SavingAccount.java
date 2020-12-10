package ru.sber.projectATM.core.bank.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SavingAccount extends Account {
    private int id;
    private String PAN;
    private Balance balance;

    public Balance getSavingBalance() {
        return balance;
    }
}
