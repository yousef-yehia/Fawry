package fawrySystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MobilePaymentServices implements Service { //template method pattern
	static ArrayList<Provider> providers = new ArrayList<Provider>();

	public void mobilePaymentProvidersCreate() {
		Provider vodafone = new VodafoneMobileRecharge();
		Provider etisalat = new EtisalatMobileRecharge();
		Provider orange = new OrangeMobileRecharge();
		Provider we = new WeMobileRecharge();
		
		providers.add(vodafone);
		providers.add(etisalat);
		providers.add(orange);
		providers.add(we);

	}
	public void pay(User user) {}
}
