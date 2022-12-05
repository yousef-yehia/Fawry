package fawrySystem;

import java.util.ArrayList;

public class User extends Account{

	Double wallet;
	Discount userdiscount;
	// an array to store all the user's purchases
	ArrayList<Double> purchases = new ArrayList<Double>();
	
	public User(String userName, String email, String password) {
		super(userName, email, password);
		wallet = 0.0;
	}
}