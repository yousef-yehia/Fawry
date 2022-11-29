package fawry;

public abstract class User {
	public static String userName;
	public static String email;
	public static String password;
	public static boolean registered;
	public abstract void signIn(String username, String email ,String password);

}
