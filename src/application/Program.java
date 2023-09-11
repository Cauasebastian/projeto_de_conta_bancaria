package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Account account;
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("enter the account name: ");
        int number = sc.nextInt();
        System.out.println("Enter the account holder: ");
        String holder = sc.nextLine();
        sc.nextLine();
        System.out.println("Is there a initial deposit? (Y/N)");
        char response = sc.next().charAt(0);

        if (response == 'y'|| response == 'Y'){
            System.out.println("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
           account = new Account(initialDeposit,number,holder);
        }
    else { account = new Account(holder, number);
         }
        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account);

        System.out.println();
        System.out.println("Enter a deposit value:");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("updated account data:");
        System.out.println(account);

        System.out.println();
        System.out.println("Enter a withdraw value:");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("updated account data:");
        System.out.println(account);
    }

}
