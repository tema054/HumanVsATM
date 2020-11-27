package ru.sber.projectATM.core.accounting;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.sber.projectATM.core.handbook.Currency;

@Setter
@Getter
public class Balance {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;

}
