package fawrySystem;

import java.util.Scanner;

public class DonationsServicesFactory implements Service { 

	public void printProviders() {
		System.out.println("1- Cancer Hospital \n2- Schools \n3- NGO  \n0- Exit");
	}

	 public  DonationsServicesFactory(User user) {
		Scanner scc = new Scanner(System.in);
		int company;
		do {
			printProviders();
			company = scc.nextInt();
		switch (company) {
		case 1:
			Provider cancerHospital = new CancerHospitalDonation();
			cancerHospital.pay(user);
			break;
		case 2:
			Provider Schools = new SchoolsDonation();
			Schools.pay(user);
			break;
		case 3:
			Provider NGO = new NGOsDonation();
			NGO.pay(user);
			break;
		case 0:
			break;
		default:
			
		}
		break;
	}
		while(company != 0);
	 }


}
