package tuc.ece.cs102.vehicles;

public abstract class Passenger extends Vehicle {
	private int maximumNumberOfPassengers;
	private float cubicCentimeters;

	public Passenger(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, int maximumNumberOfPassengers, float cubicCentimeters) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice);
		this.maximumNumberOfPassengers = maximumNumberOfPassengers;
		this.cubicCentimeters = cubicCentimeters;
	}

	public int getMaximumNumberOfPassengers() {
		return maximumNumberOfPassengers;
	}

	public void setMaximumNumberOfPassengers(int maximumNumberOfPassengers) {
		this.maximumNumberOfPassengers = maximumNumberOfPassengers;
	}

	public float getCubicCentimeters() {
		return cubicCentimeters;
	}

	public void setCubicCentimeters(float cubicCentimeters) {
		this.cubicCentimeters = cubicCentimeters;
	}

	public String toString() {
		return getCarInfo() + " maximum number of passengers: " + getMaximumNumberOfPassengers()
				+ " cubic centimeteres of engine: " + getCubicCentimeters();
	}

}
