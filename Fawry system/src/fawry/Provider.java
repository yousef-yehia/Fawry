package fawry;

public  class Provider {
	String name;
	boolean isCash,isCredit,isWallet;
	public Provider(String name, boolean isWallet, boolean isCredit, boolean isCash) {
		this.name = name;
		this.isCash = isCash;
		this.isCredit = isCredit;
		this.isWallet = isWallet;
	}
//	public abstract void pay(User user);
}