package fawrySystem;

import java.util.Scanner;

public  class MobilePaymentServicesFactory implements Service { 
	static Discount servicediscount;
	
	public void printProviders() {
		System.out.println("1- Vodafone \n2- Etisalat \n3- Orange \n4- We \n0- Exit");
	}

	 public MobilePaymentServicesFactory(User user) {
		Scanner scc = new Scanner(System.in);
		int company;
		do {
			printProviders();
			company = scc.nextInt();
		switch (company) {
		case 1:
			Provider vodafone = new VodafoneMobileRecharge();
			vodafone.pay(user);
			break;
		case 2:
			Provider etisalat = new EtisalatMobileRecharge();
			etisalat.pay(user);
			break;
		case 3:
			Provider orange = new OrangeMobileRecharge();
			orange.pay(user);
			break;
		case 4:
			Provider we = new WeMobileRecharge();
			we.pay(user);
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}
		while(company != 0);
	 }

	public void pay(User user) {}
}
