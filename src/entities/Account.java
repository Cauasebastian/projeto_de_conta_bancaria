package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;



    public Account(String holder, int number) {
        super();
        this.number = number;
        this.holder = holder;
    }

    public Account(double initialDeposit,int number, String holder) {

        deposit(initialDeposit);
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double initialDeposit) {
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public String toString(){
        return "account: "
                + number+
                ", holder: "
                +holder+
                ",balance: $"
                +String.format("%.2f", balance);
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        } else {
            balance -= amount;
            balance -= 5.0; // Deduct a fee of 5 reais
        }
    }
}
