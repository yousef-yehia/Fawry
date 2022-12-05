package fawrySystem;


import java.util.Scanner;

public class LandlineServicesFactory implements Service {
	static Discount servicediscount;
	public void printProviders() {
		System.out.println("1- Monthly Receipt \n2- Quarter Receipt \n0- Exit");
	}
	// the user chooses which receipt he wants to pay
	public LandlineServicesFactory(User user) {
		Scanner scc = new Scanner(System.in);
		int company;
		do {
			printProviders();
			company = scc.nextInt();
			switch (company) {
			case 1:
				Provider monthly = new MonthlyLandlineReceipt();
				monthly.pay(user);
				break;
			case 2:
				Provider quarter = new QuarterLandlineReceipt();
				quarter.pay(user);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (company != 0);
	}
}
