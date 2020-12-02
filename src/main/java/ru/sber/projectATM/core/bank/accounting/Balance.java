package ru.sber.projectATM.core.bank.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import ru.sber.projectATM.core.handbook.Currency;

@AllArgsConstructor
@Getter
public class Balance {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;

}
