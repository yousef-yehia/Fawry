package fawrySystem;
import java.util.ArrayList;
public class RefundRequest {
	double amount;
	User user;
	//a boolean to store the state of a refund request made by use
	//False = declined or in progress
	//True = accepted by admin
	boolean state;
	public static ArrayList<RefundRequest>  refunds = new ArrayList<RefundRequest>();
	public RefundRequest(double amount , User user) {
		this.user  = user;
		this.amount = amount;
		this.state = false;
	}
}
