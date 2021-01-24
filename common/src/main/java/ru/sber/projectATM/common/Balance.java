package ru.sber.projectATM.common;

import lombok.*;

import ru.sber.projectATM.common.handbook.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Balance {
    @NonNull
    private Double amount;
    @NonNull
    private Currency currency;

}
