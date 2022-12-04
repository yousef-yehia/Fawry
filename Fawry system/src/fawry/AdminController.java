package fawrySystem;

import java.util.Scanner;

public class AdminController {
	Admin admin;
	Scanner scc = new Scanner(System.in);

	public AdminController() {
		admin = new Admin("1", "1", "1");
	}
	
	public void signIn() {
		System.out.print("enter the username :");
		String username = scc.nextLine();
		System.out.print("enter your email :");
		String email = scc.nextLine();
		System.out.print("enter your password :");
		String password = scc.nextLine();
		if (admin.userName.equals(username) && admin.email.equals(email) && admin.password.equals(password)) {
			System.out.println("successful login (admin)");
			displayInterface();
		} else {
			System.out.println("wrong credintials!");
		}
	}
	public void addProvider(int choice) {
		String providerName;
		String cash;
		boolean isCash;
		switch(choice) {
		case 1: 
			System.out.println("Enter the name of the new provider: ");
			providerName = scc.next();
			System.out.println("Does this service provider support cash payment (type y if yes and n if no): ");
			cash = scc.next();
			isCash = supportCash(cash);
			MobilePaymentServices.providers.add(new Provider(providerName, true, true, isCash));
			break;
		case 2:
			System.out.println("Enter the name of the new provider: ");
			providerName = scc.next();
			System.out.println("Does this service provider support cash payment (type y if yes and n if no): ");
			cash = scc.next();
			isCash = supportCash(cash);
			InternetPaymentServices.providers.add(new Provider(providerName, true, true, isCash));
			break;
		}
	}
		
	public boolean supportCash(String cash) {
		if(cash.equals("y"))
			return true;
		else 
			return false;
	}

	private void displayInterface() {
		int choice;
		do{
			System.out.println("1- Add a new service provider \n2- manage refunds \n3- add discount ");
			choice = scc.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("Please choose which service would you like to add a new provider to.\n 1- Mobile Recharge service \n 2- Internet payment service \n 0-exit ");
				int service;
				service = scc.nextInt();
				addProvider(service);
				break;
			}
		}while(choice != 0);
	}
}

