
// Program.java
package application;

import entities.Account;
import entities.AccountNotFoundException;
import entities.Bank;
import entities.InsufficientFundsException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        // Adicionar contas
        bank.addAccount(new Account(1, "Alice"));
        bank.addAccount(new Account(2, "Bob"));
        bank.addAccount(new Account(3, "Charlie"));

        // Realizar operações
        try {
            bank.depositInAccount(1, 1000);
            bank.withdrawFromAccount(1, 300);
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar dados das contas
        bank.getAccounts().forEach(System.out::println);

        sc.close
      
        // Mostrar dados das contas
        bank.getAccounts().forEach(System.out::println);

        // Realizar operações com tratamento de exceções
        try {
            System.out.println("Digite o número da conta para depósito:");
            int accountNumber = sc.nextInt();
            System.out.println("Digite o valor do depósito:");
            double depositValue = sc.nextDouble();
            bank.depositInAccount(accountNumber, depositValue);

            System.out.println("Digite o número da conta para saque:");
            accountNumber = sc.nextInt();
            System.out.println("Digite o valor do saque:");
            double withdrawValue = sc.nextDouble();
            bank.withdrawFromAccount(accountNumber, withdrawValue);
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar dados atualizados das contas
        bank.getAccounts().forEach(System.out::println);

        sc.close();
    }
}