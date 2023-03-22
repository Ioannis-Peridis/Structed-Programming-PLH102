package tuc.ece.cs102.vehicleRentalCompanyConsole;

import tuc.ece.cs102.list.*;
import tuc.ece.cs102.customers.*;

public class CustomerItem extends Item {
	private Customer customer;

	public CustomerItem(Customer customer) {
		super();
		this.customer = customer;
	}

	
	
	public Object key() {
		return customer.getAFM();

	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if (((Integer) key()).compareTo((Integer) o.key()) < 0)
			return true;
		return false;

	}

	public String toString() {
		return customer.toString();

	}

	public void print() {
		customer.print();
	}
	
	public Object getData(){
		return this.customer;
	}
}

