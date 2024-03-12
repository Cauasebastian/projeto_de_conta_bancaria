// Account.java
package entities;

public class Account {
    private int number;
    private double balance;
    private String clientName;

    public Account(int number, String clientName) {
        this.number = number;
        this.clientName = clientName;
        this.balance = 0.0;
    }

    public int getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Erro: O valor do saque deve ser positivo.");
        } else if (amount + 5.0 > balance) { // Inclui a taxa de saque
            throw new InsufficientFundsException("Saldo insuficiente para realizar o saque.");
        } else {
            balance -= amount + 5.0; // Taxa de saque
            System.out.println("Saque realizado com sucesso!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}

