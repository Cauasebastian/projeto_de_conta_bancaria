// Bank.java
package entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountByNumber(int number) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Conta não encontrada."));
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void depositInAccount(int number, double amount) throws AccountNotFoundException {
        Account account = findAccountByNumber(number);
        account.deposit(amount);
    }

    public void withdrawFromAccount(int number, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account account = findAccountByNumber(number);
        account.withdraw(amount);
    }
}

// AccountNotFoundException.java
package entities;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

// InsufficientFundsException.java
package entities;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}