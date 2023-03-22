package tuc.ece.cs102.vehicles;

public class Truck extends Vehicle {
	private float width;
	private float heigh;
	private float maximumPermissibleLoad;

	public Truck(String uniqueTrafficNumber, String brandAndTrafficModel, int releaseYear, int sumOfMiles,
			int rentalPrice, float width, float heigh, float maximumPermissibleLoad) {
		super(uniqueTrafficNumber, brandAndTrafficModel, releaseYear, sumOfMiles, rentalPrice);
		this.width = width;
		this.heigh = heigh;
		this.maximumPermissibleLoad = maximumPermissibleLoad;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeigh() {
		return heigh;
	}

	public void setHeigh(float heigh) {
		this.heigh = heigh;
	}

	public float getMaximumPermissibleLoad() {
		return maximumPermissibleLoad;
	}

	public void setMaximumPermissibleLoad(float maximumPermissibleLoad) {
		this.maximumPermissibleLoad = maximumPermissibleLoad;
	}

	public String toString() {
		return getCarInfo() + " width :" + getWidth() + " heigh :" + getHeigh();
	}

	public void print() {
		System.out.println("Vehicle>Track: " + this.toString());
	}
}
