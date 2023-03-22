package tuc.ece.cs102.vehicleRentalCompanyConsole;

import java.text.SimpleDateFormat;
import java.util.Date;

import tuc.ece.cs102.customers.*;
import tuc.ece.cs102.list.*;
import tuc.ece.cs102.rentals.*;
import tuc.ece.cs102.util.*;
import tuc.ece.cs102.vehicleRentalCompanyConsole.*;
import tuc.ece.cs102.vehicles.*;

public class Company {
	private String name;
	private int afm;
	private String hydra;
	private VehicleRentalCompanySortedList vehicles;
	private VehicleRentalCompanySortedList rentals;
	private VehicleRentalCompanySortedList customers;
	
	static int counter=100;
	
	// constructor
	public Company() {
		// variables
		name = "The vehicle rental company of Chania!";
		afm = 2018030069;
		hydra = "Halepa,Chania";

		// lists
		vehicles = new VehicleRentalCompanySortedList();
		customers = new VehicleRentalCompanySortedList();
		rentals = new VehicleRentalCompanySortedList();

		// customers
		customers.insert(new CustomerItem(new Citizen("Nikos Arabatzis", 123456789, "3028210373", "Chania", "Greece")));
		customers.insert(new CustomerItem(new Citizen("Johanes Stevenson", 987456321, "4621097275", "Stockholm", "Sweden")));
		customers.insert(new CustomerItem(new Business("Nick Malone", 741258963, "3536975589", "Dublin", "Ireland", 10)));
		customers.insert(new CustomerItem(new Business("Tim Roberg", 258963147, "3265738648", "Brussels", "Belgium", 20)));

		// vehicles
		vehicles.insert(new VehicleItem(new Car("XNK5544", "Mercedes C200", 120000, 2012, 50, 5, 1800, 4, true, CarFeatures.BATTERY)));
		vehicles.insert(new VehicleItem(new Car("XNA1204", "Honda Pilot", 2019, 5000, 70, 7, 3000, 5, true, CarFeatures.DIESEL)));
		vehicles.insert(new VehicleItem(new Car("XNM1345", "Mercedes MiniBXS", 2018, 6000, 100, 12, 3000, 4, false, CarFeatures.DIESEL)));
		vehicles.insert(new VehicleItem(new Bike("XNO1706", "Yamaha YZF-R3", 2015, 60500, 45, 2, 600, BikeFeatures.TOURING)));
		vehicles.insert(new VehicleItem(new Bike("XNX9901", "Kawasaki Ninja 300", 2012, 32000, 30, 2, 30, BikeFeatures.CRUISER)));
		vehicles.insert(new VehicleItem(new Truck("XNA1207", "Vovlvo FH16", 2017, 90000, 250, 20000, 3, 4)));
		vehicles.insert(new VehicleItem(new Truck("XNA1208", "Scania XD1", 2018, 80000, 300, 25000, 3, 3)));

		// rentals
		Date ldate1 = new Date();
		ldate1 = date("03/04/2019");
		Date expdate1 = new Date();
		expdate1 = date("22/04/2019");
		Date ldate2 = new Date();
		ldate2 = date("05/04/2019");
		Date expdate2 = new Date();
		expdate2 = date("08/04/2019");
		Date ldate3 = new Date();
		ldate3 = date("05/06/2019");
		Date expdate3 = new Date();
		expdate3 = date("15/06/2019");
		Date ldate4 = new Date();
		ldate4 = date("05/06/2019");
		Date expdate4 = new Date();
		expdate4 = date("15/06/2019");
		;
		Date ldate5 = new Date();
		ldate5 = date("05/06/2019");
		Date expdate5 = new Date();
		expdate5 = date("14/06/2019");
		Date ldate6 = new Date();
		ldate6 = date("07/06/2019");
		Date expdate6 = new Date();
		expdate6 = date("15/06/2019");
		Date ldate7 = new Date();
		ldate7 = date("05/06/2019");
		Date expdate7 = new Date();
		expdate7 = date("15/06/2019");
		Date ldate8 = new Date();
		ldate8 = date("05/08/2019");
		Date expdate8 = new Date();
		expdate8 = date("15/08/2019");

		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(123456789), searchVehicleByUTN("XNK5544"), ldate1, expdate1, 950)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(987456321), searchVehicleByUTN("XNA1204"), ldate2, expdate2, 210)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(741258963), searchVehicleByUTN("XNO1706"), ldate3, expdate3, 405)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(258963147), searchVehicleByUTN("XNX9901"), ldate4, expdate4, 240)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(123456789), searchVehicleByUTN("XNA1207"), ldate5, expdate5, 2250)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(987456321), searchVehicleByUTN("XNA1208"), ldate6, expdate6, 2400)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(741258963), searchVehicleByUTN("XNK5544"), ldate7, expdate7, 450)));
		rentals.insert(new RentalItem(new Rental(counter++,searchCustomerByAFM(258963147), searchVehicleByUTN("XNM1345"), ldate8, expdate8, 800)));

	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
	}

	public String getHydra() {
		return hydra;
	}

	public void setHydra(String hydra) {
		this.hydra = hydra;
	}

	// prints all vehicles
	public void printVehicles() {
		System.out.println("----------------COMPANY--------------------");
		System.out.println(name);
		System.out.println("----------------VEHICLES-------------------");
		vehicles.print();
	}

	// adds customer to list
	public void addCustomer(Customer cus) {
		customers.insert(new CustomerItem(cus));
	}

	// adds vehicle to list
	public void addVehicle(Vehicle veh) {
		vehicles.insert(new VehicleItem(veh));
	}

	// adds rental to list
	public void addRental(Rental ren) {
		rentals.insert(new RentalItem(ren));
	}

	// search for customer
	public Customer searchCustomerByAFM(int afm) {
		CustomerItem cItem = (CustomerItem) customers.search(afm);
		if (cItem == null) {
			return null;
		} else {
			return (Customer) cItem.getData();
		}
	}

	// search for vehicle
	public Vehicle searchVehicleByUTN(String utn) {
		VehicleItem vItem = (VehicleItem) vehicles.search(utn);
		if (vItem != null) {
			return (Vehicle) vItem.getData();
		} else {
			return null;
		}
	}

	// delete customer
	public void deleteCustomerByAFM(int afm) {
		CustomerItem cItem = (CustomerItem) customers.search(afm);
		if (cItem != null) {
			vehicles.delete(cItem);
			System.out.println("The customer with afm: " + afm + " was succesfully deleted by the catalogue");

		}
	}

	// delete vehicle
	public void deleteVehicleByUTN(String utn) {
		VehicleItem vItem = (VehicleItem) vehicles.search(utn);
		if (vItem != null) {
			vehicles.delete(vItem);
			System.out.println(
					"The vehicle with unique traffice number: " + utn + " was succesfully deleted by the catalogue");

		} else
			System.out.println("Vehicle not found");
	}

	// delete rental
	public void deleteRentalByRC(int rc) {
		RentalItem rItem = (RentalItem) rentals.search(rc);
		if (rItem != null) {
			rentals.delete(rItem);
			System.out.println("The rental with rental code: " + rc + " was succesfully deleted by the catalogue");

		} else
			System.out.println("Rental not found");
	}

	// prints vehicles by category
	public void printVehiclesbyCategory(String catClass) {
		vehicles.printAllInHierarchy(catClass);
	}

	// prints customers by category
	public void printCustomersbyCategory(String catClass) {
		customers.printAllInHierarchy2(catClass);
	}

	// adds new rental
	public void addNewRental(Customer customer, Vehicle vehicle, Date rentDate, Date expDate, int discPer) {
		if (customer != null && vehicle != null) {
			boolean isOverlap = false;
			DatePeriod period = new DatePeriod(rentDate, expDate);
			isOverlap = findOverlap(period, vehicle);
			if (isOverlap == true) {
				System.out.println("This car will not be available at this period of time. please Select another one.");
			} else {
				try {
					if (Class.forName("tuc.ece.cs102.vehicles.Car").isInstance(vehicle) && Class.forName("tuc.ece.cs102.customers.Citizen").isInstance(customer)) {
						if ((!((Car) vehicle).IX())) {
							System.out.println(
									"Sorry this car is not for private use,it can only be rented by a business.");
						} else {
							Rental r = new Rental(counter++,customer, vehicle, rentDate, expDate, 0);
							r.setTotalRentalPrice(totalRentalCost(vehicle, period, discPer));
							addRental(r);
							System.out.println("Rental was successfully added to the catalogs.");
						}
					} else {
						Rental r = new Rental(counter++,customer, vehicle, rentDate, expDate, 0);
						r.setTotalRentalPrice(totalRentalCost(vehicle, period, discPer));
						addRental(r);
						System.out.println("Rental was successfully added to the catalogue.");
					}
				} catch (ClassNotFoundException ex) {
					System.out.println("Error Finding the Class.");
				}
			}
		} else
			System.out.println("Error: Undefined Customer or Vehicle...");

	}

	// prints rentals by vehicles
	public void printVehicleRentals(String vehCode) {
		Vehicle veh = (searchVehicleByUTN(vehCode));
		VehicleItem vehItem = new VehicleItem(veh);
		Node tmp = rentals.getFirst();
		Item item;
		boolean isRented = false;
		int counter = 1;
		while (tmp != null) {
			item = new VehicleItem(((Rental) tmp.getValue().getData()).getVehicle());
			if (vehItem.equals(item)) {
				isRented = true;
				System.out.println("Rental number: " + counter++ + " ,Vehicles Unique traffic number: " + vehCode);
				((Rental) (tmp.getValue().getData())).print();
			}
			tmp = tmp.getNext();
		}
		if (isRented == false) {
			System.out.println("There was no rental in the catalogue for this vehicle.");
		}
	}

	// print rentals by customer
	public void printCustomerRentals(int afm) {
		Customer cust = (searchCustomerByAFM(afm));
		CustomerItem custItem = new CustomerItem(cust);
		Node tmp = rentals.getFirst();
		Item item;
		boolean hasRentals = false;
		int counter = 1;
		while (tmp != null) {
			item = new CustomerItem(((Rental) tmp.getValue().getData()).getCustomer());
			if (custItem.equals(item)) {
				hasRentals = true;
				System.out.println("Rental number: " + counter++ + " ,Customer's AFM: " + afm);
				((Rental) (tmp.getValue().getData())).print();
			}
			tmp = tmp.getNext();
		}
		if (hasRentals == false) {
			System.out.println("There was no rental in the catalogue for this customer.");
		}
	}

	// prints rentals by date
	public void printRentalsByPeriod(Date rentalDate, Date expirationDate) {
		DatePeriod period = new DatePeriod(rentalDate, expirationDate);
		Node tmp = rentals.getFirst();
		Item item;
		boolean rentalsExist = false;
		int counter = 1;
		System.out.println("There are: ");
		while (tmp != null) {
			item = tmp.getValue();
			if (((Rental) item.getData()).getRentDur().overlaps(period)) {
				rentalsExist = true;
				System.out.print(counter++ + ".	");
				((Rental) (tmp.getValue().getData())).print();
			}
			tmp = tmp.getNext();
		}
		if (rentalsExist == false) {
			System.out.println("There are no rentals at this period of time.");
		}
	}

	// finds total rental cost
	public float totalRentalCost(Vehicle veh, DatePeriod period, int discPer) {
		int diffinDays = period.toDays();
		float totalRentalCost = (100 - discPer) * diffinDays * veh.getRentalPrice() / 100;
		return totalRentalCost;
	}

	// finds overlap
	public boolean findOverlap(DatePeriod period, Vehicle veh) {
		boolean isOverlap = false;
		Node tmp = rentals.getFirst();
		Item item;
		while (tmp != null) {
			item = tmp.getValue();
			if (((Rental) item.getData()).getRentDur().overlaps(period) && veh.getUniqueTrafficNumber()
					.equals(((Rental) item.getData()).getVehicle().getUniqueTrafficNumber())) {
				isOverlap = true;
				return isOverlap;
			}
			tmp = tmp.getNext();
		}
		return isOverlap;
	}

	// dates
	public static Date date(String s) {
		Date d = new Date();
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			d = sdf1.parse(s);
			return d;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}