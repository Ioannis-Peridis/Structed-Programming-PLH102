package tuc.ece.cs102.rentals;

import java.util.Date;
import tuc.ece.cs102.util.*;
import tuc.ece.cs102.vehicles.*;
import tuc.ece.cs102.customers.*;


public class Rental {
	
	private  int rentalCode;
	private Customer customer;
	private Vehicle vehicle;
	private float totalRentalPrice;
	private Date rentingDate;
	private Date expirationDate;

	private DatePeriod rentDur;

	/* class constructors */
	public Rental() {
	}

	public Rental(int r,Customer customer, Vehicle vehicle, Date rentD, Date expirD,float totalRentalPrice) {
		this.customer = customer;
		this.vehicle = vehicle;
		rentingDate = rentD;
		expirationDate = expirD;
		this.totalRentalPrice = totalRentalPrice;
		this.rentDur = new DatePeriod(rentingDate, expirationDate);
		this.rentalCode=r;
	}

	/* getters and setters */
	public int getRentalCode() {
		return rentalCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public float getTotalRentalPrice() {
		return totalRentalPrice;
	}

	public void setTotalRentalPrice(float totalRentalPrice) {
		this.totalRentalPrice = totalRentalPrice;
	}

	public Date getRentingDate() {
		return rentingDate;
	}

	public void setRentingDate(Date rentingDate) {
		this.rentingDate = rentingDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public DatePeriod getRentDur() {
		return rentDur;
	}

	public void setRentDur(DatePeriod rentDur) {
		this.rentDur = rentDur;
	}

	/* method used to get (as string) the renting period of a renting car */
	public String getRentingPeriod() {
		String result = "";
		result += "From: ";
		result += this.rentingDate.toString();

		result += "Until: ";
		result += this.expirationDate.toString();

		return result;
	}

	// method used to print rental information and change line
	public void print() {
		System.out.println("Rental code: " + getRentalCode() + ", " + this.rentDur.toString() + "Total rent price : "
				+ this.totalRentalPrice);
	}
}
