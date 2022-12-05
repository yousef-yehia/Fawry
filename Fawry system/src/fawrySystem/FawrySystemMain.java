package fawrySystem;

import java.util.Scanner;  

public class FawrySystemMain {

	public static void main(String[] args) {
		int choice = 0;
		Scanner scc = new Scanner(System.in);

		AdminController admin = new AdminController();
		UserController user = new UserController();
		// creates some users and admins to use
		admin.createAdmin();
		user.createUser();

		
        System.out.println("Admin username: admin \t User username: hassan\nAdmin email: admin \t User email:hassan@gmail\nAdmin pass: 1111 \t User pass: 1111 \n");
        System.out.println("Welcome Eng hassan to Fawry payment system");

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
			case 0:
				break;
			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);
	}

}
