package fawrySystem;

public class OverallDiscounts extends Discount {
		public OverallDiscounts(double amount) {
			this.type = "Overall";
			this.amount = amount;
			this.flag = true;
		}
}