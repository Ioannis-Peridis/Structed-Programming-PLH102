package tuc.ece.cs102.CarRentComp;

import java.util.Date;
import tuc.ece.cs102.util.*;

public class Rental {
	private int rentalCode;
	private Customer customer;
	private Car car;
	private float totalRentalPrice;
	private Date rentingDate;
	private Date expirationDate;

	private DatePeriod rentDur;

	/*class constructors*/
	public Rental() {
	}

	public Rental(Customer customer,Car car,Date rentD,Date expirD) {
		this.customer=customer;
		this.car=car;
		rentingDate=rentD;
		expirationDate=expirD;
		this.rentDur=new DatePeriod(rentingDate,expirationDate);
	}

	/*getters and setters*/
	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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

	/*method used to get (as string) the renting period of a renting car*/
	public String getRentingPeriod() {
		String result ="";
		result +="From: ";
		result +=this.rentingDate.toString();

		result+="Until: ";
		result+=this.expirationDate.toString();

		return result;
	}

	//method used to print rental information
	public void print() {
		System.out.print("Rental code: " + this.rentalCode+ ", " + this.rentDur.toString() + "Total rent price : " + this.totalRentalPrice);
	}
	//method used to print rental information and change line
	public void println() {
		System.out.println("Rental code: " + this.rentalCode+ ", " + this.rentDur.toString() + "Total rent price : " + this.totalRentalPrice);
	}}




