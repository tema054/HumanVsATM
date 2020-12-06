package ru.sber.projectATM.core.bank.front;
import ru.sber.projectATM.core.bank.accounting.Balance;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;
import ru.sber.projectATM.core.handbook.Currency;
import ru.sber.projectATM.core.handbook.Status;

public class FrontSystem {
    private boolean isOnline = true;

    public void checkConnect() throws FrontSystemNotAvailable {
        if (!isOnline) {
            new FrontSystemNotAvailable();
        }
    }

    public BalanceResponse getBalance(String pan, int pin) {
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(new Balance(10.0, Currency.RUR));
        balanceResponse.setRC(Status.SUCCESS);
        return balanceResponse;
    }
}
