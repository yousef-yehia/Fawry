package fawrySystem;

import java.util.ArrayList;

public abstract class Discount {
	//a flag to store the state of the discount  
	boolean flag = false;
	String type;
	double amount;
	// an array to store all the added discounts by the admin
	public static ArrayList<Discount> Discounts = new ArrayList<Discount>();
}
