package fawrySystem;

import java.util.Scanner;

public class EtisalatMobileRecharge extends Provider {
	public EtisalatMobileRecharge() {
		super();
		this.name = "etisalat";
	}
	public void pay(User user) {
		Scanner sc = new Scanner(System.in);
		double amount;
		int m;

		do {
			System.out.print("\nEnter amount to recharge: (enter 0 to exit)");
			amount = sc.nextDouble();

			if (amount > 0) {
				DisplayProviders.printPayment(this);
				m = sc.nextInt();
			} else {
				m = 0;
			}
			switch (m) {

			case 1:
				if (user.wallet >= amount) {
					user.wallet -= amount;
					System.out.println("Payment succesful! thanks for using  " +this.name + "\nyour balance now = " + user.wallet);
					break;
				} else {
					System.out.println("Payment failed! not enough credit!");
					break;
				}

			case 2:
				System.out.print("Enter credit card number: "); // check if valid
				@SuppressWarnings("unused") long ccnum = sc.nextLong();
				System.out.print("Enter pin: "); // check if valid
				@SuppressWarnings("unused") int pin = sc.nextInt();
				;
				System.out.println("Payment succesful! thanks for using " + this.name);
				break;

			case 3: {
				System.out.println("Payment succesful! thanks for using " + this.name);

				break;
			}

			default:
				System.out.println("Exit sucessfully");

			}
		
		} while (m != -0);

	}


}
