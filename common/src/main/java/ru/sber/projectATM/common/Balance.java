package ru.sber.projectATM.common;

import lombok.*;

import ru.sber.projectATM.common.handbook.*;


@Value
@ToString
public class Balance implements java.io.Serializable {
    private Double amount;
    private Currency currency;

}
