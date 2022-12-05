package fawrySystem;
//strategy pattern

public class PayByWallet implements Payment {

	public static void pay(User user , String name , double amount) {
		
		if (user.wallet >= amount) {
			user.wallet -= amount;
			System.out.println("Payment succesful! thanks for your payment to " + name + "\nyour balance now = " + user.wallet);
		} else {
			System.out.println("Payment failed! not enough credit!");
		}
	}

}
