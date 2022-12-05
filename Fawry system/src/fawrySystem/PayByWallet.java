package fawrySystem;
//strategy pattern

public class PayByWallet implements Payment {
	//the function decrements the amount paid from the user's wallet if the wallet contains enough funds
	@Override
	public  void pay(User user , String name , double amount) {
		
		if (user.wallet >= amount) {
			user.wallet -= amount;
			System.out.println("Payment succesful! thanks for your payment to " + name + "\nyour balance now = " + user.wallet);
		} else {
			System.out.println("Payment failed! not enough credit!");
		}
		user.purchases.add(amount);
	}

}
