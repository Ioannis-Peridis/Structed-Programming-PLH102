package tuc.ece.cs102.vehicles;

public class Bike extends Passenger {
	private BikeFeatures feature2;

	public Bike(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters, BikeFeatures feature2) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice,
				maximumNumberOfPassengers, cubicCentimeters);
		this.feature2 = feature2;

	}

	public Bike(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice,
				maximumNumberOfPassengers, cubicCentimeters);

	}

	public BikeFeatures getFeature2() {
		return feature2;
	}

	public void setFeature2(BikeFeatures feature2) {
		this.feature2 = feature2;
	}

	public String toString() {
		return super.toString() + "\t\t Bike Features: " + getFeature2();
	}

	public void print() {
		System.out.println("Vehicle>Passenger>Bike: " + this.toString());
	}

}
