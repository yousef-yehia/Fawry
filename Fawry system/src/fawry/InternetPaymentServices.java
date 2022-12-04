package fawrySystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class InternetPaymentServices implements Service { //template method pattern
	static ArrayList<Provider> providers = new ArrayList<Provider>();
	public void internetPaymentServicesCreate() {
		Provider vodafone = new VodafoneInternetPayment();
		Provider etisalat = new EtisalatInternetPayment();
		Provider orange = new OrangeInternetPayment();
		Provider we = new WeInternetPayment();
		

		providers.add(vodafone);
		providers.add(etisalat);
		providers.add(orange);
		providers.add(we);
	}
	public void pay(User user) {}
}