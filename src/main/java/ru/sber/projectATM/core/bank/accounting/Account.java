package ru.sber.projectATM.core.bank.accounting;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@NonNull
@Setter
@Getter
public class Account {
    private int id;
    private String PAN;
    private Balance balance;


}
