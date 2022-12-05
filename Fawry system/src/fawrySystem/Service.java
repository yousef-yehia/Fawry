package fawrySystem;

import java.util.ArrayList;

public interface Service { //template method pattern
	ArrayList<Provider> providers = new ArrayList<Provider>();
	public void printProviders();
	
}
