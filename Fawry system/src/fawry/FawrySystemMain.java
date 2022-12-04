package fawrySystem;

import java.util.Scanner;

public class FawrySystemMain {

	public static void main(String[] args) {
		int choice = 0;

		Scanner scc = new Scanner(System.in);

		AdminController admin = new AdminController();
		UserController user = new UserController();
		LandlineServices landLine = new LandlineServices();
		DonationsServices donation = new DonationsServices();

		donation.donationCreate();
		user.createUser();
		landLine.landLineProvidersCreate();

		System.out.println("Welcome to payment system");

		do {
			System.out.println(" (1) Sign In user \n (2) Sign Up (user) \n (3) Sign in admin \n (0) exit");
			Scanner sc = new Scanner(System.in);
			choice = scc.nextInt();

			switch (choice) {
			case 1: {
				user.signIn();
				break;
			}

			case 2: {
				user.signUp();
				break;
			}
			case 3: {
				admin.signIn();
			}
			default:
				System.out.println("GoodBye");
			}

		} while (choice != 0);
	}

}
