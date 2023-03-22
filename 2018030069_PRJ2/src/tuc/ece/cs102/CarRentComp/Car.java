package tuc.ece.cs102.CarRentComp;

import java.util.Vector;

public class Car {

	private String uniqueTrafficNumber;
	private String brandAndTrafficModel;
	private int releaseYear;
	private double averageFuelConsumption;
	private int sumOfMiles;
	private int rentalPrice;

	private Vector<Features> features;
	private Vector<Rental> carRentals;

	/*class constructors*/
	public Car() {
		this.carRentals=new Vector<Rental>();
		this.features=new Vector<Features>();
	}

	public Car(String utn,String batf,int ry,int rp,float afc,int som ) {
		uniqueTrafficNumber=utn;
		brandAndTrafficModel=batf;
		releaseYear=ry;
		averageFuelConsumption=afc;
		sumOfMiles=som;
		rentalPrice=rp;
		this.carRentals=new Vector<Rental>();
		this.features=new Vector<Features>();

	}


	/*getters and setters*/

	public String getUniqueTrafficNumber() {
		return uniqueTrafficNumber;
	}

	public void setUniqueTrafficNumber(String uniqueTrafficNumber) {
		this.uniqueTrafficNumber = uniqueTrafficNumber;
	}

	public String getBrandAndTrafficModel() {
		return brandAndTrafficModel;
	}

	public void setBrandAndTrafficModel(String brandAndTrafficModel) {
		this.brandAndTrafficModel = brandAndTrafficModel;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public double getAverageFuelConsumption() {
		return averageFuelConsumption;
	}

	public void setAverageFuelConsumption(double averageFuelConsumption) {
		this.averageFuelConsumption = averageFuelConsumption;
	}

	public int getSumOfMiles() {
		return sumOfMiles;
	}

	public void setSumOfMiles(int sumOfMiles) {
		this.sumOfMiles = sumOfMiles;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public Vector<Features> getFeatures() {
		return features;
	}

	public void setFeatures(Vector<Features> features) {
		this.features = features;
	}

	public Vector<Rental> getCarRentals() {
		return carRentals;
	}

	public void setCarRentals(Vector<Rental> carRentals) {
		this.carRentals = carRentals;
	}

	/*method used to get car information and change line*/
	public void println() {
		System.out.println("Brand and traffic model: "+this.brandAndTrafficModel+" "+"Unique traffic number: "+this.uniqueTrafficNumber);
	}

	/*method used to get car information */
	public void print() {
		System.out.print("Brand and traffic model: "+this.brandAndTrafficModel+" "+"Unique traffic number: "+this.uniqueTrafficNumber);
	}

	/*method used to get a summary of car information*/
	public String getCarInfo() {
		return this.brandAndTrafficModel+ ", "+this.releaseYear+", "+"["+ this.uniqueTrafficNumber+"]";
	}
	//add a car rental
	public void addCarRental(Rental r) {
		carRentals.add(r);
	}
	//adds a features
	public void addFeature(Features f) {
		features.add(f);
	}
}
