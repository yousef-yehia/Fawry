package fawrySystem;
//strategy pattern

import java.util.Scanner;

public class PayByCredit implements Payment {

	public static void pay(User user , String name , double amount) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter credit card number: "); // check if valid
		sc.nextLong();
		System.out.print("Enter pin: "); // check if valid
		sc.nextInt();
		
		System.out.println("Payment succesful! thanks for your payment to " + name);
		System.out.println("your total payment =" + amount);

	}

}
