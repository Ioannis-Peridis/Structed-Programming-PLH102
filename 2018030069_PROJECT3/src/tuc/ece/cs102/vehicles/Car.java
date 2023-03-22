package tuc.ece.cs102.vehicles;

public class Car extends Passenger {
	private CarFeatures feature1;
	private int numOfDoors;
	private boolean ix;

	public Car(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters, int numOfDoors, boolean ix,
			CarFeatures feature1) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice,
				maximumNumberOfPassengers, cubicCentimeters);
		this.numOfDoors = numOfDoors;
		this.ix = ix;
		this.feature1 = feature1;
	}

	public Car(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters, int numOfDoors,
			CarFeatures feature1) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice,
				maximumNumberOfPassengers, cubicCentimeters);
		this.numOfDoors = numOfDoors;
		this.feature1 = feature1;
	}

	public Car(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters, int numOfDoors) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice,
				maximumNumberOfPassengers, cubicCentimeters);
		this.numOfDoors = numOfDoors;
	}

	public boolean isIx() {
		return ix;
	}

	public void setIx(boolean ix) {
		this.ix = ix;
	}

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public CarFeatures getFeature1() {
		return feature1;
	}

	public void setFeature1(CarFeatures feature) {
		this.feature1 = feature;
	}

	public String toString() {
		return super.toString() + "\t\t Car Features: " + getFeature1();
	}

	public void print() {
		System.out.println("Vehicle>Passenger>Car: " + this.toString());
	}

	public boolean IX() {
		if (this.getMaximumNumberOfPassengers() > 7) {
			return false;
		} else
			return true;
	}
}
