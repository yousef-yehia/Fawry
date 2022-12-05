package fawrySystem;

// a class to display all the payment method supported by a provider
public class DisplayProviders {
	public static void printPayment(Provider provider) {

		System.out.println("\n PLease choose your method of payment :");

		if (provider.isCredit) {
			System.out.println("(1) wallet ");
		}
		if (provider.isWallet) {
			System.out.println("(2) credit ");
		}
		if (provider.isCash) {
			System.out.println("(3) Cash ");
		}
		System.out.println("(0) exit");
	}

}
