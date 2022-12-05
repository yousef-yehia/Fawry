package fawrySystem;

import java.util.Scanner;

public class SpecificDiscount extends Discount { 
	public  SpecificDiscount(double amount) {
		Scanner scc = new Scanner(System.in);
		this.type = "Specific ";
		this.amount = amount;
		this.flag = true;
		System.out.println("Choose which service you want to add the discount to.\n1- Mobile recharge\n2- Internet payment\n3- Landline receipt\n0- Exit ");
		int choice;
		choice = scc.nextInt();
		switch(choice) {
		case 1:
			this.type += "mobile";
			break;
		case 2:
			this.type += "internet";
			break;
		case 3:
			this.type += "landline";
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}
}
