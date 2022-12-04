package fawry;

import java.util.ArrayList;
import java.util.Scanner;

public class DonationsServices implements Service { //template method pattern

	static ArrayList<Provider> providers = new ArrayList<Provider>();

	public DonationsServices(ArrayList<User> userList, int indexOfActive) {
		Scanner scc = new Scanner(System.in);

		printProviders();
		int company = scc.nextInt() - 1;
		if (company >= 0) {
			pay(userList.get(indexOfActive), company);
		}
	}

	public DonationsServices() {
		// TODO Auto-generated constructor stub
	}

	public void donationCreate() {
		Provider cancerHospital = new Provider("Cancer Hospital", true, true, true);
		Provider schools = new Provider("Schools", true, true, false);

		providers.add(cancerHospital);
		providers.add(schools);

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
			System.out.print("\nEnter amount to Donate: (enter 0 to exit)");
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
					System.out.println("Payment succesful Thanks for your dination to " + providers.get(company).name+ "! \n your balance now = " + user.wallet);
					break;
				} else {
					System.out.println("Payment failed! not enough credit!");
					break;
				}

			case 2:
				System.out.print("Enter credit card number: "); // check if valid
				sc.nextLong();
				System.out.print("Enter pin: "); // check if valid
				sc.nextInt();
				;
				System.out.println("Payment succesful! Thanks for your dination to " + providers.get(company).name );
				break;

			case 3: {
				System.out.println("Payment succesful! Thanks for your dination to " + providers.get(company).name );

				break;
			}

			default:
				System.out.println("Exit sucessfully");

			}
		} while (m != -0);

	}

}
