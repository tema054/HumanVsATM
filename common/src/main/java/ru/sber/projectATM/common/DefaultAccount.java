package ru.sber.projectATM.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DefaultAccount extends Account {
    private int id;
    private String PAN;
    private Balance balance;

    public Balance getDefaultBalance() {
        return balance;
    }
}
