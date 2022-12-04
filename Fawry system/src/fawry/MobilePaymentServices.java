package fawry;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePaymentServices implements Service { //template method pattern
	static ArrayList<Provider> providers = new ArrayList<Provider>();

	public MobilePaymentServices(ArrayList<User> userList, int indexOfActive) {
		Scanner scc = new Scanner(System.in);

		printProviders();
		int company = scc.nextInt() - 1;
		if (company >= 0) {
			pay(userList.get(indexOfActive), company);
		}
	}

	public MobilePaymentServices() {
		// TODO Auto-generated constructor stub
	}

	public void mobilePaymentProvidersCreate() {
		Provider vodafone = new Provider("vodafone", true, true, true);
		Provider etisalat = new Provider("etisalat", true, true, true);
		Provider orange = new Provider("orange", true, true, false);

		providers.add(vodafone);
		providers.add(etisalat);
		providers.add(orange);

	}

	@Override
	public void printProviders() {
		DisplayProviders.printProviders(providers);
	}

	@Override
	public void pay(User user, int company) {
		Scanner sc = new Scanner(System.in);
		double amount;
		int m;

		do {
			System.out.print("\nEnter amount to recharge: (enter 0 to exit)");
			amount = sc.nextDouble();

			if (amount > 0) {
				DisplayProviders.printPayment(providers.get(company));
				m = sc.nextInt();
			} else {
				m = 0;
			}
			switch (m) {

			case 1:
				if (user.wallet >= amount) {
					user.wallet -= amount;
					System.out.println("Payment succesful! thanks for using  " + providers.get(company).name + "\nyour balance now = " + user.wallet);
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
				System.out.println("Payment succesful! thanks for using " + providers.get(company).name);
				break;

			case 3: {
				System.out.println("Payment succesful! thanks for using " + providers.get(company).name);

				break;
			}

			default:
				System.out.println("Exit sucessfully");

			}
		
		} while (m != -0);

	}
}
