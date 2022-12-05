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
		for (Discount itr : Discount.Discounts) {
			if (itr.type.equals("Specific landline") && itr.flag == true) {
				amount *= 1 - (itr.amount / 100);
			}
			if (itr.type.equals("Overall") && itr.flag == true) {
				amount *= 1 - (itr.amount / 100);
			}

		}
		// remove the discount if used the first time
		for (int i = 0; i < Discount.Discounts.size(); i++) {
			if (Discount.Discounts.get(i).type.equals("Overall")) {
				Discount.Discounts.remove(i);
			}
			if (Discount.Discounts.get(i).type.equals("Specific landline")) {
				Discount.Discounts.remove(i);
			}
		}
		switch (method) {

		case 1:
			PayByWallet wallet = new PayByWallet();
			wallet.pay(user, this.name, amount);
			method = 0;
			break;

		case 2:
			PayByCredit credit = new PayByCredit();
			credit.pay(user, this.name, amount);
			method = 0;
			break;

		case 3: {
			PayByCash cash = new PayByCash();
			cash.pay(user, this.name, amount);
			method = 0;
			break;
		}
		case 0:
			break;
		default:
			System.out.println("Invalid choice!");
		}

	}
}
