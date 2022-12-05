package fawrySystem;
// strategy pattern
public interface Payment {
	public abstract void pay(User user , String name , double amount);
}
