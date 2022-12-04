package fawry;

import java.util.ArrayList;

public interface Service { //template method pattern
	ArrayList<Provider> providers = new ArrayList<Provider>();
	public void pay(User user , int company);
	public void printProviders();
	

}
