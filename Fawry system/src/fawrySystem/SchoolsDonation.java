package fawrySystem;

import java.util.Scanner;

public class SchoolsDonation extends Provider {

	public SchoolsDonation() {
		super();
		this.name = "School";
	}

	@Override
	public void pay(User user) {
		Scanner sc = new Scanner(System.in);
		double amount;
		int method;

		System.out.print("\nEnter amount to donate: (enter 0 to exit)");
		amount = sc.nextDouble();

		if (amount > 0) {
			DisplayProviders.printPayment(this);
			method = sc.nextInt();
		} else {
			method = 0;
		}
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
			System.out.println("Exit sucessfully");
		}

	}

}
