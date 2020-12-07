package ru.sber.projectATM.core.bank.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@NonNull
@Setter
@Getter
@AllArgsConstructor
public class Account {
    private int id;
    private Balance balance;
}
