package fawrySystem;
//strategy pattern

public class PayByCash implements Payment {

	public static void pay(User user , String name , double amount) {
		System.out.println("Payment succesful! thanks for your payment to " + name);
		System.out.println( "your total payment = " + amount );

	}

}
