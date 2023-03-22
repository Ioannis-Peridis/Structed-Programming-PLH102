package tuc.ece.cs102.CarRentComp;

import java.util.Vector;

public class Customer {

	private String fullName;
	private String drivingLicenseNumber;
	private int yearsOfDrivingLicense;
	private String countryOfOrigin;

	private Vector<Rental> customerRentals;

	/*class constructors*/
	public Customer() {
		this.customerRentals= new Vector<Rental>();
	}
	public Customer(String fn,String dln,String coo,int yodl) {
		fullName=fn;
		drivingLicenseNumber=dln;
		yearsOfDrivingLicense=yodl;
		countryOfOrigin=coo;
		this.customerRentals= new Vector<Rental>();
	}

	/*getters and setters*/
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public int getYearsOfDrivingLicense() {
		return yearsOfDrivingLicense;
	}

	public void setYearsOfDrivingLicense(int yearsOfDrivingLicense) {
		this.yearsOfDrivingLicense = yearsOfDrivingLicense;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Vector<Rental> getCustomerRentals() {
		return customerRentals;
	}

	public void setCustomerRentals(Vector<Rental> customerRentals) {
		this.customerRentals = customerRentals;
	}

	/*method used to print customer information*/
	public void print() {
		System.out.print("Name of customer: "+this.fullName+" "+"Driving lisence number: "+this.drivingLicenseNumber);
	}

	/*method used to print customer information and change line*/
	public void println() {
		System.out.println("Name of customer: "+this.fullName+" "+",Driving lisence number: "+this.drivingLicenseNumber+",Years of driving license:"+this.yearsOfDrivingLicense);
	}

	/*method used to get a summary of customer information*/
	public String getCustomerInfo() {
		return this.fullName + " ," +"["+this.drivingLicenseNumber+"]";
	}

	//add new customer rental
	public void addCustomerRental(Rental rental) {
		customerRentals.add(rental);
	}}