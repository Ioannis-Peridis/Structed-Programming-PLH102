package tuc.ece.cs102.vehicleRentalCompanyConsole;

import tuc.ece.cs102.list.*;
import tuc.ece.cs102.rentals.*;

public class RentalItem extends Item {
	private Rental rental;

	public RentalItem(Rental rental) {
		super();
		this.rental = rental;
	}
	public Object key() {
		return rental.getRentalCode();

	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		return false;

	}

	public String toString() {
		return rental.toString();

	}

	public void print() {
		rental.print();

	}
	
	
	public Object getData(){
		return this.rental;
	}
}
