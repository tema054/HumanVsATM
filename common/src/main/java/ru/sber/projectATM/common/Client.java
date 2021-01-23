package ru.sber.projectATM.common;

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
