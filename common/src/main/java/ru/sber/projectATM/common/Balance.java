package ru.sber.projectATM.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import lombok.ToString;
import ru.sber.projectATM.common.handbook.*;

@AllArgsConstructor
@Getter
@ToString
public class Balance {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;

}
