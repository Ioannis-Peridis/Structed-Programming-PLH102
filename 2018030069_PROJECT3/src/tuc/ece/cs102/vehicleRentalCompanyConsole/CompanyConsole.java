package tuc.ece.cs102.vehicleRentalCompanyConsole;

import java.util.Date;

import tuc.ece.cs102.customers.*;
import tuc.ece.cs102.list.*;
import tuc.ece.cs102.rentals.*;
import tuc.ece.cs102.util.*;
import tuc.ece.cs102.vehicleRentalCompanyConsole.*;
import tuc.ece.cs102.vehicles.*;

public class CompanyConsole {
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	private StandardInputRead reader;
	private int userOption;

	public CompanyConsole() {
		company = new Company();
		reader = new StandardInputRead();
		userOption = 0;
		
	}
	


	public static void main(String[] args) {
		
		
		int discPer=0,afm;
		String utn;
		Date rentD,expirD;
		
		CompanyConsole cc = new CompanyConsole();
//=============================PRINT USER MENU AND CHOICES==================================================================//	

		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while (userOption != 11) {
			cc.printMenu();
			String userInput = reader.readString("What would you like to do? ");
			if (userInput == null) {
				continue;
			} else {
				try {
					userOption = Integer.parseInt(userInput);
				} catch (NumberFormatException ex) {
					userOption = 0;
				}
			}
			switch (userOption) {
			case 0:
				continue;
			case 1: // Search for a vehicle
				cc.findVehicle();
				reader.readString("Press any key to continue...");
				break;
			case 2: // Delete a vehicle
				cc.deleteVehicle();
				reader.readString("Press any key to continue...");
				break;
			case 3: // Print all vehicles
				cc.getCompany().printVehicles();
				reader.readString("Press any key to continue...");
				break;
			case 4: // Print a category of vehicles
				cc.printVehiclesByCategory();
				reader.readString("Press any key to continue...");
				break;
			case 5: // Search for customer
				cc.findCustomer();
				reader.readString("Press any key to continue...");
				break;
			case 6: // Delete a customer
				cc.deleteCustomer();
				reader.readString("Press any key to continue...");
				break;

			case 7: // Add New Rental.
				 afm = reader.readPositiveInt("Enter the customer's Afm: ");
			     utn = reader.readString("Enter the vehicle code:");
				rentD = reader.readDate("Enter the rental date:");
				expirD = reader.readDate("Enter the expiration date:");
				Customer cust = cc.getCompany().searchCustomerByAFM(afm);
				try {
					if (Class.forName("tuc.ece.cs102.customers.Business").isInstance(cust)) {
						discPer=((Business)cust).getDiscountPC();
								cc.getCompany().addNewRental(cust, cc.getCompany().searchVehicleByUTN(utn), rentD,expirD, discPer);
					} else {
						discPer = 0;
						cc.getCompany().addNewRental(cust,cc.getCompany().searchVehicleByUTN(utn), rentD, expirD, discPer);
					}

				} catch (ClassNotFoundException ex) {
					System.out.println("The class wasn't found.");
				}
				reader.readString("Press any key to continue...");
				System.out.println();
				break;

			case 8: // Print Info about Rentals
				userOption = 0;
				while (userOption != 1 && userOption != 2 && userOption != 3) {
					printMenuForInfos();
					userInput = reader.readString("What information are you looking for? ");
					userOption = 0;
					if (userInput == null) {
						continue;
					} else {
						try {
							userOption = Integer.parseInt(userInput);
						} catch (NumberFormatException ex) {
							userOption = 0;
						}
					}

					switch (userOption) {
					case 0:
						continue;
					case 1: // For Car
						System.out.println();
						utn = reader.readString("Give me The vehicle unique traffic number:");
						cc.getCompany().printVehicleRentals(utn);
						break;
					case 2: // For Customer
						System.out.println();
						afm = reader.readPositiveInt("Give me The customer's Afm:");
						cc.getCompany().printCustomerRentals(afm);
						break;
					case 3: // For Date Period
						System.out.println();
						rentD = reader.readDate("Give me rental Date:");
						expirD = reader.readDate("Give me expiration Date:");
						cc.getCompany().printRentalsByPeriod(rentD, expirD);
						break;
					default:
						System.out.println();
						System.out.println("User option " + userOption + " ignored...\n");
						System.out.println();
						continue;
					}
				}
				reader.readString("Press any key to continue...");
				break;
			case 9:// Insert a vehicle
				cc.addNewVehicle();
				reader.readString("Press any key to continue...");
				break;
			case 10:// Insert a customer
				cc.addNewCustomer();
				reader.readString("Press any key to continue...");
				break;
			case 11: // exit
				System.out.println("Thanks for using the Vehicle Rental Company Console...");
				break;
			default:
				System.out.println("User option " + userOption + " ignored...");
				continue;
			}
		}
	}

	public void printMenu() {
		System.out.println("----------------------Menu------------------------");
		System.out.println("--------------------------------------------------");
		System.out.println("1)Search for a Vehicle");
		System.out.println("2)Delete a Vehicle");
		System.out.println("3)Print all Vehicles");
		System.out.println("4)Print a category of Vehicles");
		System.out.println("5)Search for a Customer");
		System.out.println("6)Delete a Customer");
		System.out.println("7)Make new Rental");
		System.out.println("8)Print a Rental ");
		System.out.println("9)Insert a Vehicle ");
		System.out.println("10)Insert a Customer ");
		System.out.println("11)exit ");
		System.out.println("--------------------------------------------------");
		System.out.println("--------------------------------------------------");

	}

	// adds new vehicle
	public void addNewVehicle() {
		userOption = 0;
		while (userOption > 3 || userOption < 1) {
			System.out.println("===========Insert New vehicle============");
			System.out.println("1) Truck");
			System.out.println("2) Car");
			System.out.println("3) Bike");
			System.out.println("4) Cancel");
			System.out.println("=========================================");
			userOption = reader.readPositiveInt(":");
		}
		String utn, batm, fuserInput;
		int ry, som, rp, mnop, nod, answer = 0;
		float heigh, width, mpl, cc;

		Vehicle veh;
		switch (userOption) {
		case 1:
			utn = reader.readString("Truck's unique traffice number:");
			batm = reader.readString("Truck's brand and traffic model:");
			ry = reader.readPositiveInt("Truck's release year:");
			som = reader.readPositiveInt("Truck's sum of miles:");
			rp = reader.readPositiveInt("Truck's rental price:");
			heigh = reader.readPositiveFloat("Truck's heigh:");
			width = reader.readPositiveFloat("Truck's width:");
			mpl = reader.readPositiveFloat("Truck's maximum premissible load:");

			veh = new Truck(utn, batm, ry, som, rp, heigh, width, mpl);
			company.addVehicle(veh);
			System.out.println("Veheicle Added...");
			break;
		case 2:
			utn = reader.readString("Car's unique traffice number:");
			batm = reader.readString("Car's brand and traffic model:");
			ry = reader.readPositiveInt("Car's release year:");
			som = reader.readPositiveInt("Car's sum of miles:");
			rp = reader.readPositiveInt("Car's rental price:");
			mnop = reader.readPositiveInt("Car's maximum number of passengers:");
			cc = reader.readPositiveFloat("Car's cubic centimeters:");
			nod = reader.readPositiveInt("Car's number of doors:");

			veh = new Car(utn, batm, ry, som, rp, mnop, cc, nod);

			System.out.println();
			System.out.println("Choose what Car Feature you want to add");
			System.out.println("=================================================================");
			System.out.println("1.Diesel.........................................................");
			System.out.println("2.Gas............................................................");
			System.out.println("3.Battery........................................................");
			System.out.println("4. Exit..........................................................");
			System.out.println("=================================================================\n");

			System.out.println("Give me Car Features: ");

			fuserInput = reader.readString("");
			answer = 0;
			if (fuserInput == null) {
			} else {
				try {
					answer = Integer.parseInt(fuserInput);
				} catch (NumberFormatException ex) {
					answer = 0;
				}
			}
			switch (answer) {
			case 1:
				((Car) veh).setFeature1(CarFeatures.DIESEL);
				break;
			case 2:
				((Car) veh).setFeature1(CarFeatures.GAS);
				break;
			case 3:
				((Car) veh).setFeature1(CarFeatures.BATTERY);
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid Choise. Please Try again.");
			}
			company.addVehicle(veh);
			System.out.println("Vehicle Added...");
			break;

		case 3:
			utn = reader.readString("Bike's unique traffice number:");
			batm = reader.readString("Bike's brand and traffic model:");
			ry = reader.readPositiveInt("Bike's release year:");
			som = reader.readPositiveInt("Bike's sum of miles:");
			rp = reader.readPositiveInt("Bike's rental price:");
			cc = reader.readPositiveFloat("Bike's cubic centimeters:");

			do {
				mnop = reader.readPositiveInt("Bike's maximum number of passengers:");

				if (mnop <= 3) {

					veh = new Bike(utn, batm, ry, som, rp, mnop, cc);

					company.addVehicle(veh);
					System.out.println("Vehicle Added...");
					break;
				} else {
					System.out.print(
							"The maximum number of bike passngers is 3.Please enter another number equal or less to 3...");
				}
			} while (mnop > 3);
			cc = reader.readPositiveFloat("Bike's cubic centimeters");

			veh = new Bike(utn, batm, ry, som, rp, mnop, cc);

			System.out.println();
			System.out.println("Choose what Bike Feature you want to add");
			System.out.println("=================================================================");
			System.out.println("1.Touring........................................................");
			System.out.println("2.On_Off.........................................................");
			System.out.println("3.Cruiser........................................................");
			System.out.println("4.Sport..........................................................");
			System.out.println("5. Exit..........................................................");
			System.out.println("=================================================================\n");

			System.out.println("Give me Bike Features: ");

			fuserInput = reader.readString("");
			answer = 0;
			if (fuserInput == null) {
			} else {
				try {
					answer = Integer.parseInt(fuserInput);
				} catch (NumberFormatException ex) {
					answer = 0;
				}
			}
			switch (answer) {
			case 1:
				((Bike) veh).setFeature2(BikeFeatures.TOURING);
				break;
			case 2:
				((Bike) veh).setFeature2(BikeFeatures.ON_OFF);
				break;
			case 3:
				((Bike) veh).setFeature2(BikeFeatures.CRUISER);
				break;
			case 4:
				((Bike) veh).setFeature2(BikeFeatures.SPORT);
			case 5:
				break;
			default:
				System.out.println("Invalid Choise. Please Try again.");
			}
			company.addVehicle(veh);
			System.out.println("Vehicle Added...");
			reader.readString("Press enter  to continue...");
			break;

		}
	}

	// adds new customer
	public void addNewCustomer() {
		userOption = 0;
		while (userOption > 3 || userOption < 1) {
			System.out.println("===========Insert New Customer============");
			System.out.println("1) Citizen");
			System.out.println("2) Buziness");
			System.out.println("3) Cancel");
			System.out.println("==========================================");
			userOption = reader.readPositiveInt(":");
		}
		String name, phoneNumber, city, country;
		int afm;
		int discount;
		switch (userOption) {
		case 1:
			name = reader.readString("Citizen's Name:");
			afm = reader.readPositiveInt("Citizen's AFM:");
			phoneNumber = reader.readString("Citizen's phone number:");
			city = reader.readString("Citizen's city of residence:");
			country = reader.readString("Citizen's country of residence:");

			Citizen c = new Citizen(name, afm, phoneNumber, city, country);
			company.addCustomer(c);
			System.out.println("Customer Added...");
			break;
		case 2:
			name = reader.readString("Business's Name:");
			afm = reader.readPositiveInt("Business's AFM:");
			phoneNumber = reader.readString("Business's phone number:");
			city = reader.readString("Business's city of residence:");
			country = reader.readString("Business's country of residence:");
			discount = reader.readPositiveInt("Business's discount:");

			Business b = new Business(name, afm, phoneNumber, city, country, discount);
			company.addCustomer(b);
			System.out.println("Customer Added...");
			break;
		case 3:
			break;
		}

	}

	// finds a customer
	public void findCustomer() {
		int afm;
		afm = reader.readPositiveInt("Customer's AFM:");
		Customer cus = company.searchCustomerByAFM(afm);
		if (cus == null) {
			System.out.println("Customer not Found");
		} else {
			cus.print();
		}
	}

	// finds a vehicle
	public void findVehicle() {
		String utn;
		utn = reader.readString("Vehicle UTN:");
		Vehicle veh = company.searchVehicleByUTN(utn);
		if (veh == null) {
			System.out.println("Vehicle not Found");
		} else {
			veh.print();
		}
	}

	// delete a vehicle
	public void deleteVehicle() {
		String utn;
		utn = reader.readString("Vehicle UTN:");
		company.deleteVehicleByUTN(utn);
	}

	// delete a customer
	public void deleteCustomer() {
		int afm;
		afm = reader.readPositiveInt("Customer's AFM:");
		company.deleteCustomerByAFM(afm);
	}

	// delete a rental
	public void deleteRental() {
		int rentalCode;
		rentalCode = reader.readPositiveInt("Rental's rentalCode:");
		company.deleteRentalByRC(rentalCode);
	}

	// prints vehicles by category
	public void printVehiclesByCategory() {
		String category = reader.readString("What kind of Vehicles you want to see?");
		System.out.println("----------------COMPANY--------------------");
		System.out.println("The vehicle rental company of Chania!");
		System.out.println("---------CATEGORY OF VEHICLES--------------");
		company.printVehiclesbyCategory(category);
		System.out.println("-------------------------------------------");
	}

	// prints customers by category
	public void printCustomersByCategory() {
		String category = reader.readString("What kind of Customers you want to see?");
		System.out.println("----------------COMPANY--------------------");
		System.out.println("The vehicle rental company of Chania!");
		System.out.println("---------CATEGORY OF CUSTOMERS-------------");
		company.printCustomersbyCategory(category);
		System.out.println("-------------------------------------------");
	}

	//menu for new rental
	public static void printMenuForInfos() {
		System.out.println();
		System.out.println("\n=======================================================================================");
		System.out.println("1. Print info about a car's rental.......................................................");
		System.out.println("2. Print info about a customer's rental..................................................");
		System.out.println("3. Print info about a particular period of time..........................................");
		System.out.println("=======================================================================================");
}
}
