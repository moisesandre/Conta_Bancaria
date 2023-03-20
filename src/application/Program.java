package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) throws BusinessException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();
		
		account.withdraw(withdraw);
		System.out.printf("New balance: %.2f", account.getBalance());
		}
		catch (BusinessException e) {
			System.out.println("Withdraw error" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("unexpected error");
		}
		
		sc.close();
	}

}
