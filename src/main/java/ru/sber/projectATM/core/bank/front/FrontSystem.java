package ru.sber.projectATM.core.bank.front;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sber.projectATM.core.bank.accounting.Balance;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;
import ru.sber.projectATM.core.bank.accounting.Client;
import ru.sber.projectATM.core.bank.accounting.DefaultAccount;
import ru.sber.projectATM.core.handbook.Currency;
import ru.sber.projectATM.core.handbook.Status;

import java.util.ArrayList;


@Getter
@Setter
public class FrontSystem {
    private boolean isOnline = true;

    public void checkConnect() throws FrontSystemNotAvailable {
        if (!isOnline) {
            new FrontSystemNotAvailable();
        }
    }

    public BalanceResponse getBalance(String pan, int pin) {

        DefaultAccount defaultAccount = new DefaultAccount(2, pan, new Balance(100.00, Currency.RUR));
        Client<DefaultAccount> defaultAccountClient = new Client<DefaultAccount>(2, defaultAccount);

        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(defaultAccountClient.getAccount().getDefaultBalance());
        balanceResponse.setRC(Status.SUCCESS);
        return balanceResponse;
    }
}
