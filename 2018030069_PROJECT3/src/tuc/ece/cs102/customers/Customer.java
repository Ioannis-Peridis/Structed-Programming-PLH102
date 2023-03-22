package tuc.ece.cs102.customers;

public abstract class Customer {

	private String fullName;
	private int AFM;
	private String phoneNumber;
	private String CityOfResidence;
	private String CountryOfResidence;

	public Customer(String fullName, int aFM, String phoneNumber, String cityOfResidence, String countryOfResidence) {
		super();
		this.fullName = fullName;
		AFM = aFM;
		this.phoneNumber = phoneNumber;
		CityOfResidence = cityOfResidence;
		CountryOfResidence = countryOfResidence;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAFM() {
		return AFM;
	}

	public void setAFM(int aFM) {
		AFM = aFM;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCityOfResidence() {
		return CityOfResidence;
	}

	public void setCityOfResidence(String cityOfResidence) {
		CityOfResidence = cityOfResidence;
	}

	public String getCountryOfResidence() {
		return CountryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		CountryOfResidence = countryOfResidence;
	}

	public abstract void print();

	public abstract String toString();

	/* method used to get a summary of customer information */
	public String getCustomerInfo() {
		return "Customers name: "+this.fullName + " ," + " Customers AFM [" + this.AFM + "]" + "," + " Customers phone number (" + this.phoneNumber + ")";
	}

}
