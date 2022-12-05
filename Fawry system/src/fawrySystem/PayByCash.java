package fawrySystem;
//strategy pattern

public class PayByCash implements Payment {
	//if user chooses to pay by cash the function displays a successful message to the user and prints the amount paid
	@Override
	public void pay(User user , String name , double amount) {
		System.out.println("Payment succesful! thanks for your payment to " + name);
		System.out.println( "your total payment = " + amount );
		user.purchases.add(amount);
	}
}
