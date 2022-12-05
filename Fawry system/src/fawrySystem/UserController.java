package fawrySystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class UserController {
	ArrayList<User> userList;
	int indexOfActive;
	Scanner scc = new Scanner(System.in);

	public void createUser() {
		userList = new ArrayList<User>();
		User user1 = new User("1", "1", "1");
		User user2 = new User("yousef", "yousef email", "yousef1234");
		user1.wallet += 50;
		user2.wallet += 100;
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

		if ((getUserByUsername(username) == -1) && (getUserByEmail(email) == -1)) {

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

			if (checkUser(currentUSer, username, email, password)) {
				System.out.println("successful login user");
				displayInterface();
			}

		} else {
			System.out.println("wrong credintials!");
		}
	}

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

	public boolean checkUser(User active, String username, String email, String password) {
		if (active.userName.equals(username) && active.email.equals(email) && active.password.equals(password)) {

			return true;
		}
		return false;

	}

	public void SearchForService(ArrayList<User> userList, int indexOfActive) {
		Scanner scc = new Scanner(System.in);
		System.out.println("Please enter the service");
		String search = scc.nextLine().toLowerCase();
		if ("mobile payment services".equals(search) || "mobile".equals(search)) {
			new MobilePaymentServicesFactory(userList.get(indexOfActive));
		}
		if ("internet payment services".equals(search) || "internet".equals(search)) {
			new InternetPaymentServicesFactory(userList.get(indexOfActive));
		}
		if ("land line".equals(search) || "land".equals(search)) {
			new LandlineServicesFactory(userList.get(indexOfActive));
		}
		if ("donations".equals(search)) {
			new DonationsServicesFactory(userList.get(indexOfActive));
		} else {
			System.out.println("Please enter right service ");
		}
	}

	public void addFunds(double funds) {
		System.out.println("Please enter your credit card number");
		scc.nextLong();
		userList.get(indexOfActive).wallet += funds;
	}

	public void displayInterface() {

		int choice;
		do {
			System.out.println("1- Mobile recharge services \n2- Internet Payment services\n3- Landline services "
					+ "\n4- Donations \n5- Add funds to wallet \n6- search for service \n7- Check discounts \n0- SignOut \n");
			choice = scc.nextInt();
			switch (choice) {
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
				LandlineServicesFactory landline = new LandlineServicesFactory(userList.get(indexOfActive));
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
				SearchForService(userList, indexOfActive);
			}
//			case 7: {
//
//			}
			default:
				System.out.println();
			}

		} while (choice != 0);

	}
}