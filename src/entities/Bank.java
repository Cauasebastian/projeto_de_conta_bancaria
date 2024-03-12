// Bank.java
package entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();


    public void addAccount(Account account) {
        accounts.add(account);
    }
    //encontrar conta pelo numero
    public Account findAccountByNumber(int number) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Conta não encontrada."));
    }
    //remover conta
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    //depositar na conta
    public void depositInAccount(int number, double amount) throws AccountNotFoundException {
        Account account = findAccountByNumber(number);
        account.deposit(amount);
    }
    //sacar da conta
    public void withdrawFromAccount(int number, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account account = findAccountByNumber(number);
        account.withdraw(amount);
    }
    //retornar lista de contas
    public List<Account> getAccounts() {
        return accounts;
    }
}
