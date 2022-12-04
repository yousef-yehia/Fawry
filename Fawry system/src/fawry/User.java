package fawrySystem;

public class User extends Account{

	Double wallet;
	
	public User(String userName, String email, String password) {
		super(userName, email, password);
		wallet = 0.0;
	}
}