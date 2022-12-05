package fawrySystem;

import java.util.Scanner;

public class InternetPaymentServicesFactory implements Service { // template method pattern

	public void printProviders() {
		System.out.println("1- Vodafone \n2- Etisalat \n3- Orange \n4- We \n0- Exit");
	}

	public InternetPaymentServicesFactory(User user) {
		Scanner scc = new Scanner(System.in);
		int company;
		do {
			printProviders();
			company = scc.nextInt();

			switch (company) {
			case 1:
				Provider vodafone = new VodafoneInternetPayment();
				vodafone.pay(user);
				break;
			case 2:
				Provider etisalat = new EtisalatInternetPayment();
				etisalat.pay(user);
				break;
			case 3:
				Provider orange = new OrangeInternetPayment();
				orange.pay(user);
				break;
			case 4:
				Provider we = new WeInternetPayment();
				we.pay(user);
				break;
			}
		} while (company != 0);
	}

	public void pay(User user) {
	}
}