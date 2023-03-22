package tuc.ece.cs102.customers;


public class Citizen extends Customer {
	
	public Citizen(String fullName, int aFM, String phoneNumber, String cityOfResidence, String countryOfResidence) {
		super(fullName, aFM, phoneNumber, cityOfResidence, countryOfResidence);
		// TODO Auto-generated constructor stub
	}

	public void print() {
		System.out.println("Customer>Citizen: " + this.toString());
	}

	public String toString() {
		return getCustomerInfo();
	}

	

}
