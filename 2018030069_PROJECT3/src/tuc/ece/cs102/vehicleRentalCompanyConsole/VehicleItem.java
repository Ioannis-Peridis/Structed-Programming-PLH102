package tuc.ece.cs102.vehicleRentalCompanyConsole;

import tuc.ece.cs102.list.*;
import tuc.ece.cs102.vehicles.*;

public class VehicleItem extends Item {
	private Vehicle vehicle;
	
	
	
	public VehicleItem(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
	}

	public Object key() {
		return vehicle.getUniqueTrafficNumber();

	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if (((String) key()).compareTo((String) o.key()) < 0)
			return true;
		return false;

	}

	public String toString() {
		return vehicle.toString();

	}

	public void print() {
		vehicle.print();

	}
	
	
	public Object getData(){
		return this.vehicle;
	}
}

	
