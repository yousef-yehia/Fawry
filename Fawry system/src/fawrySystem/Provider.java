package fawrySystem;

public  abstract class Provider {
	String name;
	// 3 boolean values to store if the provider supports a specific type of payment 
	boolean isCash,isCredit,isWallet;
	public Provider() {
		this.name = " ";
		this.isCash = true;
		this.isCredit = true;
		this.isWallet = true;
	}
	public abstract void pay(User user );
}