package fawrySystem;

public  abstract class Provider {
	String name;
	
	boolean isCash,isCredit,isWallet;
	public Provider() {
		this.name = " ";
		this.isCash = true;
		this.isCredit = true;
		this.isWallet = true;
	}
	public abstract void pay(User user );
}