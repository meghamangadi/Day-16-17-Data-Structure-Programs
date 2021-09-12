package com.bridgelabz.datastructure;

import java.util.Scanner;

public class CashCounterQueue {
	public static int bankbalances = 10000;
	BankQueue bank = new BankQueue();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcom to Bank Queue");

		CashCounterQueue repeat = new CashCounterQueue();
		repeat.bankingLine();
	}

	public static int bankBalance(int amt) {
		if (amt < bankbalances) {
			if (amt > 0) {

				bankbalances = bankbalances + amt;
			} else {
				bankbalances = bankbalances + amt;
			}
		} else {
			System.out.println("Bank balance is to low you can't Withdrow money");
		}
		return bankbalances;
	}

	public void bankingLine() {

		int amountAdd = 0;
		int choice = 0;
		int person = 0;

		do {
			System.out.println();
			System.out.println("Select your choice");
			System.out.println("Enque           --> 1");
			System.out.println("Deque           --> 2");
			System.out.println("Bank Balance    --> 3");
			System.out.println("Person in Queue --> 4");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				person++;
				int addpeson = person;
				bank.enque(addpeson);
				System.out.println("Person " + addpeson + " is added on Queue");
				break;
			case 2:
				System.out.println("Select your choice");
				System.out.println("Deposit Cash  : 1");
				System.out.println("Withdraw Cash : 2");
				int select = sc.nextInt();

				switch (select) {
				case 1:

					System.out.println("How much amount you want to Deposit");
					amountAdd = sc.nextInt();
					bank.deque();
					CashCounterQueue.bankBalance(amountAdd);
					break;
				case 2:

					int minus;
					System.out.println("How much amount you want to Withdraw");
					amountAdd = sc.nextInt();
					minus = -1 * amountAdd;
					CashCounterQueue.bankBalance(minus);
					bank.deque();
					break;
				default:
					System.out.println("please Enter the amount for Transaction");

				}
				break;
			case 3:

				System.out.println("Bank balance is " + bankbalances);
				break;
			case 4:

				bank.display();
				break;
			default:
				break;
			}

		} while (choice == 1 || choice == 2 || choice == 3 || choice == 4);

	}
}
