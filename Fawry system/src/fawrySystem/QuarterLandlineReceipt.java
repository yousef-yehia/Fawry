package fawrySystem;

import java.util.Scanner;

public class QuarterLandlineReceipt extends Provider {
	public QuarterLandlineReceipt() {
		super();
		this.name = "Quarter Receipt";
		this.isCash = false;
	}

	@Override
	public void pay(User user) {
		Scanner sc = new Scanner(System.in);
		double amount = 600;
		int method;
		System.out.println("Your Quarter landline receipt is " + amount + " EGP");
		
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
			System.out.println("Wrong choice!");
		}

	}

}
