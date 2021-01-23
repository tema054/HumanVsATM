package ru.sber.projectATM.bank;

import lombok.Getter;
import lombok.Setter;

import ru.sber.projectATM.common.*;
import ru.sber.projectATM.common.handbook.*;


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
