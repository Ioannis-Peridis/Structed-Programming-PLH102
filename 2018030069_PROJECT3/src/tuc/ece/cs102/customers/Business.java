package tuc.ece.cs102.customers;

public class Business extends Customer {
	private int discountPC;

	public Business(String fullName, int aFM, String phoneNumber, String cityOfResidence, String countryOfResidence,
			int discount) {
		super(fullName, aFM, phoneNumber, cityOfResidence, countryOfResidence);
		this.discountPC = discount;
	}

	public int getDiscountPC() {
		return discountPC;
	}

	public void setDiscountPC(int discountPC) {
		this.discountPC = discountPC;
	}

	public void print() {
		System.out.println("Customer>Business: " + this.toString());
	}

	public String toString() {
		return getCustomerInfo()+"discount per centage:"+this.discountPC;
	}

}
