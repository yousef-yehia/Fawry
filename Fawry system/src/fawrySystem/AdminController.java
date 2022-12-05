package fawrySystem;

import java.util.Scanner;

public class AdminController {
	Admin admin;
	Admin EngHassan;
	Scanner scc = new Scanner(System.in);
	
	public AdminController() {
		
	}
	public void createAdmin() {
		admin = new Admin("admin","admin","1111");
	}
	
	//sign in function that checks that the admin trying to login is authorized
	public void signIn() {
		System.out.print("enter the username :");
		String username = scc.nextLine();
		System.out.print("enter your email :");
		String email = scc.nextLine();
		System.out.print("enter your password :");
		String password = scc.nextLine();
		if (admin.userName.equals(username) && admin.email.equals(email) && admin.password.equals(password)) {
			System.out.println("successful login (admin)");
			//display control panel of admin
			displayInterface();
		} else {
			System.out.println("wrong credintials!");
		}
	}
	public void addDiscount() {
		int choice;
		System.out.println("1- Overall Discount \n2- Specific Discount");
		choice = scc.nextInt();
		double amount;
		switch(choice) {
		case 1:
			//admin should enter the amount in %
			System.out.println("Enter the discount amount in %: ");
			amount = scc.nextDouble();
			//new overall discount is created
			Discount overall = new OverallDiscounts(amount);
			Discount.Discounts.add(overall);
			System.out.println("Discount added sucessfully");
			break;
		case 2:
			System.out.println("Enter the discount amount in %: ");
			amount = scc.nextDouble();
			//new specific discount is created
			Discount specific = new SpecificDiscount(amount);
			Discount.Discounts.add(specific);
			System.out.println("Discount added sucessfully");
			break;
		}
			
	}
	//function to display all the refund requests made by users 
	public void displayRefundRequests() {
		for (int i = 0; i < RefundRequest.refunds.size(); i++) {
			System.out.println(i +"- "+ RefundRequest.refunds.get(i).user.userName + " requestes a refund of "+RefundRequest.refunds.get(i).amount);
		}
	}
	//function to let the admin accept to decline a refund request made by user
	public void manageRefundRequest(int indexOfRefund) {
		for(int i = 0; i < RefundRequest.refunds.size(); i++) {
			if( i == indexOfRefund) {
				RefundRequest.refunds.get(indexOfRefund).state = true;
				RefundRequest.refunds.get(indexOfRefund).user.wallet +=RefundRequest.refunds.get(indexOfRefund).amount;
				RefundRequest.refunds.remove(i);
				System.out.println("Refund accepted sucessfully");
				break;
			}
			System.out.println("Refund declined successfuly");
		}

	}
	//display control panel of admin
	private void displayInterface() {
		int choice;
		do{
			System.out.println("1- Add Discount\n2- Manage Refunds\n0- Exit");
			choice = scc.nextInt();
			switch(choice) {
			case 1:
				addDiscount();
				break;
			case 2:
				displayRefundRequests();
				System.out.println("Enter number of refund to accept the refund request: ");
				int accepted;
				accepted = scc.nextInt();
				manageRefundRequest(accepted);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice!");
			}
			
		}while(choice != 0);
	}
}

