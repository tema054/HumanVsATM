package ru.sber.projectATM.common;

import lombok.*;

import ru.sber.projectATM.common.handbook.*;


@ToString
@Value
public class Balance {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;

}
