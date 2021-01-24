package ru.sber.projectATM.common;

import lombok.*;

import ru.sber.projectATM.common.handbook.*;


@Value
@ToString
public class Balance {
    private Double amount;
    private Currency currency;

}
