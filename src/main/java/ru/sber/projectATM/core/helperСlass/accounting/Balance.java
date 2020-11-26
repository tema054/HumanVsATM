package ru.sber.projectATM.core.helperСlass.accounting;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Balance {
    private Double amount;
    private Currency currency;
}
