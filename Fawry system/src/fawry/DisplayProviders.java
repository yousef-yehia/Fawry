package fawry;

import java.util.ArrayList;

public class DisplayProviders {
	public static void printProviders(ArrayList<Provider> providers) {
		for (int i = 0; i < providers.size(); i++) {
			System.out.print(i + 1 + "- ");
			System.out.println(providers.get(i).name);
		}
		System.out.println("0- exit");

	}

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
