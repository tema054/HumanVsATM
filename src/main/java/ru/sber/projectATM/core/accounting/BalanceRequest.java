package ru.sber.projectATM.core.accounting;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
import ru.sber.projectATM.core.handbook.Status;


@ToString
@Setter

public class BalanceRequest {

    private Balance balance;
    private Status RC;
    private String descriptionRC;

}
