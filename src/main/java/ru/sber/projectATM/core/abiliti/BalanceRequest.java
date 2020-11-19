package ru.sber.projectATM.core.abiliti;

import java.util.HashMap;
import java.util.Optional;
public interface BalanceRequest {
   Optional<HashMap<String, String>> getBalance();
}
