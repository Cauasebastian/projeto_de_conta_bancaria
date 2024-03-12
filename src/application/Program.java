package application;

import entities.Account;
import entities.AccountNotFoundException;
import entities.Bank;
import entities.InsufficientFundsException;

import java.util.Scanner;
//professor gabriel acabei optando por fazer o programa em ingles para treinar mais o idioma
//e tambem para me acostumar com a nomenclatura de variaveis e metodos em ingles
//mas caso prefira posso fazer em portugues tambem sem problemas
//Caso nescessario, o senhor pode devolver o projeto para que eu possa fazer as alterações nescessarias
//desde ja agradeço a compreensão

// Programa principal
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
        System.out.println("Dados das contas após operações:");
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
        System.out.println("Dados das contas após as operações:");
        bank.getAccounts().forEach(System.out::println);

        sc.close();
    }
}
