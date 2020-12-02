package ru.sber.projectATM.core.bank.front;
import ru.sber.projectATM.core.bank.accounting.Balance;
import ru.sber.projectATM.core.bank.accounting.BalanceRequest;
import ru.sber.projectATM.core.handbook.Currency;
import ru.sber.projectATM.core.handbook.Status;

public class FrontSystem {
    private boolean frontStatus = true;

    public void checkConnect() throws FrontSystemNotAvailable {
        if (!frontStatus) {
            new FrontSystemNotAvailable();
        }
    }

    public BalanceRequest getBalance(String pan, int pin) {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setBalance(new Balance(10.0, Currency.RUR));
        balanceRequest.setRC(Status.SUCCESS);
        return balanceRequest;
    }
}
