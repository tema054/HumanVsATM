package ru.sber.projectATM.core.bank.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Client<T extends Account> {
    @NonNull
    private int id;
    private T account;

}
