package fawrySystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class UserController {
	ArrayList<User> userList;
	ArrayList<Discount> Discounts = Discount.Discounts;
	int indexOfActive;
	Scanner scc = new Scanner(System.in);

	// function that creates an array of registered users and adds 2 users to it
	public void createUser() {
		userList = new ArrayList<User>();
		User user1 = new User("1", "1", "1");
		User user2 = new User("hassan", "hassan@gmail", "1111");
		user1.wallet += 500;
		user2.wallet += 1000;
		userList.add(user1);
		userList.add(user2);
	}

	public void signUp() {

		System.out.print("enter the username :");
		String username = scc.nextLine();
		System.out.print("enter your email :");
		String email = scc.nextLine();
		System.out.print("enter your password :");
		String password = scc.nextLine();
		// condition to check if the user is not already registered in the system
		if ((getUserByUsername(username) == -1) && (getUserByEmail(email) == -1)) {
			// if he is not it creates a new user and adds him to the list of users
			User user = new User(username, email, password);
			userList.add(user);
			System.out.println("User added sucessfully!");
		} else {
			System.out.println("this user name already exists couldn't signup");
		}
	}

	public void signIn() {
		User currentUSer;

		System.out.print("enter the username :");
		String username = scc.nextLine();
		System.out.print("enter your email :");
		String email = scc.nextLine();
		System.out.print("enter your password :");
		String password = scc.nextLine();
		if (getUserByUsername(username) != -1) {
			currentUSer = userList.get(getUserByUsername(username)); // currentUSer is the user that logged in.
			// condition to check if the user is registered in the system
			if (checkUser(currentUSer, username, email, password)) {
				System.out.println("Successful login user!\n");
				displayInterface();
			}

		} else {
			System.out.println("wrong credintials!");
		}
	}

	// function that returns the index of the user in the user list
	public int getUserByUsername(String username) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).userName.equals(username)) {
				indexOfActive = i;
				return i;
			}
		}
		return -1;
	}

	public int getUserByEmail(String email) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).email.equals(email)) {
				return i;
			}
		}
		return -1;
	}

	// function that checks if the credentials inputed are correct or no
	public boolean checkUser(User active, String username, String email, String password) {
		if (active.userName.equals(username) && active.email.equals(email) && active.password.equals(password)) {

			return true;
		}
		return false;

	}

	// function to create an object of the service that the user searched on
	public void getService(int numberOfService) {

		String s = Integer.toString(numberOfService);

		if ("1- Mobile recharge services".contains(s)) {
			new MobilePaymentServicesFactory(userList.get(indexOfActive));
		}
		if ("2- internet payment services".contains(s)) {
			new InternetPaymentServicesFactory(userList.get(indexOfActive));
		}
		if ("3- land line".contains(s)) {
			new LandlineServicesFactory(userList.get(indexOfActive));
		}
		if ("4- donations".contains(s)) {
			new DonationsServicesFactory(userList.get(indexOfActive));
		} else {
			System.out.println("No service found that matches your search!");
		}
	}

	public int SearchForService() {
		// array to store all the services names
		ArrayList<String> services = new ArrayList<String>();
		// a flag to tell if the search of the user is an existing service
		boolean flag = false;
		services.add("1- Mobile recharge services");
		services.add("2- Internet recharge services");
		services.add("3- Landline services");
		services.add("4- Donation services");

		System.out.println("Please enter the service you are searching for: ");
		String searchName = scc.next().toLowerCase();
		// a loop that iterates the services array to check if their is a service that
		// matches the user's search
		for (String itr : services) {
			if (itr.toLowerCase().contains(searchName)) {
				System.out.println(itr);
				// flag becomes true if the query of the user is a present service
				flag = true;
			}
		}
		// if the flag is true it prompts the user to choose which service he wants
		// according to his query
		if (flag) {
			System.out.println("Enter the number of the service you want to use: ");
			int numberOfService = scc.nextInt();
			return numberOfService;
		} else {
			return 0;
		}
	}

	// a function that adds funds to the user's wallet
	public void addFunds(double funds) {
		System.out.println("Please enter your credit card number: ");
		scc.nextLong();
		System.out.println("Please enter your pin: ");
		scc.nextInt();
		userList.get(indexOfActive).wallet += funds;
		System.out.println("An amount of " + funds + " was added successfly to your wallet balance!");
		System.out.println("Your new balance now is " + userList.get(indexOfActive).wallet + "\n");
	}

	// a function that prints all the available discounts added by the admins
	public void checkForDiscounts() {
		for (int i = 0; i < Discounts.size(); i++) {
			System.out.println(Discounts.get(i).type);
		}
		if (Discounts.size() == 0) {
			System.out.println("There is no discounts right now");
		}
	}

	// function to let the user request a refund on any of his purchases
	public void requestRefund(User user, int indxOfPurchase) {
		double amount = userList.get(indexOfActive).purchases.get(indxOfPurchase);
		RefundRequest.refunds.add(new RefundRequest(amount, user));
		userList.get(indexOfActive).purchases.remove(indxOfPurchase);
	}

	// displays all the purchases the current user has made
	public boolean displayPurchaseHistory() {
		if (userList.get(indexOfActive).purchases.size() == 0)
			return false;
		for (int i = 0; i < userList.get(indexOfActive).purchases.size(); i++) {
			System.out.println(i + "- amount paid: " + userList.get(indexOfActive).purchases.get(i));
		}
		return true;
	}

	// displays the user panel
	public void displayInterface() {

		int choice;
		do {
			System.out.println("1- Mobile recharge services \n2- Internet Payment services\n3- Landline services "
					+ "\n4- Donations \n5- Add funds to wallet \n6- search for service \n7- Check discounts \n8- Request refund \n0- SignOut \n");
			choice = scc.nextInt();
			switch (choice) {
			// user chooses which service he wants and a factory of that service is created
			case 1: {
				MobilePaymentServicesFactory mobile = new MobilePaymentServicesFactory(userList.get(indexOfActive));
				break;
			}
			case 2: {
				InternetPaymentServicesFactory internet = new InternetPaymentServicesFactory(
						userList.get(indexOfActive));
				break;
			}
			case 3: {
				new LandlineServicesFactory(userList.get(indexOfActive));
				break;
			}
			case 4: {
				new DonationsServicesFactory(userList.get(indexOfActive));
				break;
			}
			case 5: {
				System.out.println("Enter the amount you want to add: ");
				double amount = scc.nextDouble();
				addFunds(amount);
				break;
			}
			case 6: {
				getService(SearchForService());
				break;
			}
			case 7: {
				checkForDiscounts();
				break;
			}
			case 8:
				// function that displays the current user's purchase history
				boolean isPurchase = displayPurchaseHistory();
				if (!isPurchase) {
					System.out.println("No purchases found that you can request a refund on!");
					break;
				}
				System.out.println("Enter the number of the purchase you wish to refund (Enter -1 to return): ");
				int purchase = scc.nextInt();
				if (purchase == -1) {
					break;
				}
				requestRefund(userList.get(indexOfActive), purchase);
				System.out.println("Your refund request was submitted successfuly!");
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);

	}
}