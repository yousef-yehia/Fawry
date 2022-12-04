package fawry;

import java.util.Scanner;

public class AdminController {
	Admin admin;
	Scanner scc = new Scanner(System.in);

	public AdminController() {
		admin = new Admin("admin", "admin@gmail", "admin");
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

	private void displayInterface() {
		// TODO Auto-generated method stub
		
	}
	
}
