package ru.sber.projectATM.core;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.sber.projectATM.core.bank.ATM.ATM;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Setter
@AllArgsConstructor
public class User {
    @Pattern(regexp = "^(\\d{4})(\\d{4,10})(\\d{4})$")
    private String pan;
    @Pattern(regexp = "^\\d{4,6}$")
    @Min(0000)
    @Max(9999)
    private int pin;

    public BalanceResponse getBalance(ATM atm) {
        return atm.getBalance(pan, pin);
    }
}
