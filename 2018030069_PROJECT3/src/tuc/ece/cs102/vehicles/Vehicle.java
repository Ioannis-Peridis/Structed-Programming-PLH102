package tuc.ece.cs102.vehicles;

public abstract class Vehicle {

	private String uniqueTrafficNumber;
	private String brandAndTrafficModel;
	private int releaseYear;
	private int sumOfMiles;
	private int rentalPrice;

	public Vehicle(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice) {
		super();
		this.uniqueTrafficNumber = uniqueTrafficNumber;
		this.brandAndTrafficModel = brandAndTrafficModel;
		this.releaseYear = releaseYear;
		this.sumOfMiles = sumOfMiles;
		this.rentalPrice = rentalPrice;
	}

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

	public abstract void print();

	public abstract String toString();
	

	/* method used to get a summary of car information */
	public String getCarInfo() {
		return "Vehicles brand and traffic model: "+this.brandAndTrafficModel + ", Vehicles release year: " + this.releaseYear + ",Vehicles unique traffic number: " + "[" + this.uniqueTrafficNumber + "]";
	}
}
