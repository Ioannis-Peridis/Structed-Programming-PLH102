package tuc.ece.cs102.vehicleRentalCompanyConsole;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.list.SortedList;

public class VehicleRentalCompanySortedList extends SortedList {

	public VehicleRentalCompanySortedList() {
		super();

	}

	public Item search(String key) {
		Node tmpNode = head;
		while (tmpNode != null) {
			if (tmpNode.getValue().key().equals(new String(key))) {
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}

	public Item search(int key) {
		Node tmpNode = head;
		while (tmpNode != null) {
			if (tmpNode.getValue().key().equals(new Integer(key))) {
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}

	public void printAllInHierarchy(String className) {
		Node tmp = head;
		try {
			while (tmp != null) {
				Item item = tmp.getValue();
				if (Class.forName("tuc.ece.cs102.vehicles." + className).isInstance(item.getData())) {
					item.print();
				}
				tmp = tmp.getNext();
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("This class " + className + " does not exist...");
		}
	}

	public void printAllInHierarchy2(String className) {
		Node tmp = head;
		try {
			while (tmp != null) {
				Item item = tmp.getValue();
				if (Class.forName("tuc.ece.cs102.customers." + className).isInstance(item.getData())) {
					item.print();
				}
				tmp = tmp.getNext();
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("This class " + className + " does not exist...");
		}
	}

}
