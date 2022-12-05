package fawrySystem;

import java.util.Scanner;

public class MonthlyLandlineReceipt extends Provider {
	public MonthlyLandlineReceipt() {
		super();
		this.name = "Monthly Receipt";
	}

	@Override
	public void pay(User user) {
		Scanner sc = new Scanner(System.in);
		double amount = 200;
		int method;
		System.out.println("Your Monthly landline receipt is " + amount + " EGP");
		
		DisplayProviders.printPayment(this);
		method = sc.nextInt();
		switch (method) {

		case 1:

			PayByWallet.pay(user, this.name, amount);
			method = 0;
			break;

		case 2:

			PayByCredit.pay(user, this.name, amount);
			method = 0;
			break;

		case 3: {
			PayByCash.pay(user, this.name, amount);
			method = 0;
			break;
		}

		default:
			System.out.println(" ");

		}

	}

}
