package tuc.ece.cs102.main;

import tuc.ece.cs102.util.StandardInputRead;
import tuc.ece.cs102.CarRentComp.Car;
import tuc.ece.cs102.CarRentComp.Customer;
import tuc.ece.cs102.CarRentComp.Features;
import tuc.ece.cs102.CarRentComp.RentalCompany;
import tuc.ece.cs102.util.DatePeriod;
import java.util.Date;


public class MainConsole {

	public static void main(String[] args) {

		/*Create a new company*/

		RentalCompany carRent=new RentalCompany ("TUC Company",201803006,"University Of Chania");

		/*populate cars catalogue*/
		carRent.addCar(new Car("XNK5544","Ford Fiesta",2012,33,6.4f, 120000));
		carRent.findCarByUTN("XNK5544").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNK5544").addFeature(Features.DIESEL);

		carRent.addCar(new Car("XNA1204","Opel Corsa",2015,45,4.7f , 80000));
		carRent.findCarByUTN("XNA1204").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNA1204").addFeature(Features.DIESEL);
		carRent.findCarByUTN("XNA1204").addFeature(Features.LEATHER_SEATS);

		carRent.addCar(new Car("XNO1706","Nissan Micra",2015,45,5f , 60500));
		carRent.findCarByUTN("XNO1706").addFeature(Features.DIESEL);
		carRent.findCarByUTN("XNO1706").addFeature(Features.CABRIOLET);
		carRent.findCarByUTN("XNO1706").addFeature(Features.LEATHER_SEATS);

		carRent.addCar(new Car("XNX9901","Lancia Ypsilon",2012,30,3.5f , 32000));
		carRent.findCarByUTN("XNX9901").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNX9901").addFeature(Features.DIESEL);
		carRent.findCarByUTN("XNX9901").addFeature(Features.AUTOMATIC);

		carRent.addCar(new Car("XNA1207","Toyota Yaris",2017,50,2.7f , 17000));
		carRent.findCarByUTN("XNA1207").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNA1207").addFeature(Features.HYBRID);
		carRent.findCarByUTN("XNA1207").addFeature(Features.AUTOMATIC);

		carRent.addCar(new Car("XNA1208","Nissan Qashqai",2015,60,6.8f , 80000));
		carRent.findCarByUTN("XNA1208").addFeature(Features.SEVEN_SEATS);
		carRent.findCarByUTN("XNA1208").addFeature(Features.DIESEL);
		carRent.findCarByUTN("XNA1208").addFeature(Features.FOUR_WHEEL_DRIVE);

		carRent.addCar(new Car("XNA1209","Ford Mustang",2015,45,4.7f , 80000));
		carRent.findCarByUTN("XNA1209").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNA1209").addFeature(Features.AUTOMATIC);
		carRent.findCarByUTN("XNA1209").addFeature(Features.LEATHER_SEATS);

		carRent.addCar(new Car("XNH1210","Opel Corsa",2018,80,3.6f , 500));
		carRent.findCarByUTN("XNH1210").addFeature(Features.AUTOMATIC);
		carRent.findCarByUTN("XNH1210").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("XNH1210").addFeature(Features.LEATHER_SEATS);

		carRent.addCar(new Car("HKZ1211","Toyota Aygo",2018,45,3.2f , 6000));
		carRent.findCarByUTN("HKZ1211").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("HKZ1211").addFeature(Features.DIESEL);
		carRent.findCarByUTN("HKZ1211").addFeature(Features.AUTOMATIC);

		carRent.addCar(new Car("MHO1212","Audi A3",2015 ,58,6.1f , 33000));
		carRent.findCarByUTN("MHO1212").addFeature(Features.AIR_CONDITION);
		carRent.findCarByUTN("MHO1212").addFeature(Features.AUTOMATIC);
		carRent.findCarByUTN("MHO1212").addFeature(Features.LEATHER_SEATS);

		//populate customer catalogue
		carRent.addCustomer(new Customer("Nikos Arabatzis","RPS442","Greece", 3));
		carRent.addCustomer(new Customer("Johanes Stevenson","RFF839","Sweden", 12));
		carRent.addCustomer(new Customer("Katerina Mpampinioti","HK6689","Greece", 2));
		carRent.addCustomer(new Customer("Marilena Karopoulou","PK0967","Greece", 5));
		carRent.addCustomer(new Customer("Nick Malone","JFK8FR","Ireland", 14));
		carRent.addCustomer(new Customer("Tim Roberg","HJK31F","Belgium", 9));
		carRent.addCustomer(new Customer("Mario Marcelano","ITF934","Italy", 6));
		carRent.addCustomer(new Customer("Mantalena Paliarini","ITJ798","Italy", 3));
		carRent.addCustomer(new Customer("Klaus Regling","DEF987","Germany", 18));
		carRent.addCustomer(new Customer("Manousos Manousakis","GR092","Greece", 20));

		//populate  Rentals
		Date rentDate= new Date();
		rentDate= carRent.StringToDate("03/04/2019");
		Date expDate=new Date();
		expDate=carRent.StringToDate("22/04/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("RPS442"), carRent.findCarByUTN("XNX9901"), rentDate, expDate,570.00f);

		rentDate= carRent.StringToDate("05/04/2019");
		expDate=carRent.StringToDate("08/04/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("RFF839"), carRent.findCarByUTN("XNA1207"), rentDate, expDate,150.00f);

		rentDate= carRent.StringToDate("05/06/2019");
		expDate=carRent.StringToDate("15/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("HK6689"), carRent.findCarByUTN("XNA1208"), rentDate, expDate, 600.00f);

		rentDate= carRent.StringToDate("05/06/2019");
		expDate=carRent.StringToDate("15/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("PK0967"), carRent.findCarByUTN("XNA1209"), rentDate, expDate,450.00f);

		rentDate= carRent.StringToDate("05/06/2019");
		expDate=carRent.StringToDate("14/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("JFK8FR"), carRent.findCarByUTN("XNH1210"), rentDate, expDate,720.00f);

		rentDate= carRent.StringToDate("07/06/2019");
		expDate=carRent.StringToDate("15/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("HJK31F"), carRent.findCarByUTN("HKZ1211"), rentDate, expDate,360.00f);

		rentDate= carRent.StringToDate("05/06/2019");
		expDate=carRent.StringToDate("15/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("ITF934"), carRent.findCarByUTN("MHO1212"), rentDate, expDate,464.00f);

		rentDate= carRent.StringToDate("03/05/2019");
		expDate=carRent.StringToDate("19/05/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("RPS442"), carRent.findCarByUTN("XNX9901"), rentDate, expDate,448.80f);

		rentDate= carRent.StringToDate("07/07/2019");
		expDate=carRent.StringToDate("12/07/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("PK0967"), carRent.findCarByUTN("XNA1207"), rentDate, expDate,250.00f);

		rentDate= carRent.StringToDate("07/06/2019");
		expDate=carRent.StringToDate("15/06/2019");
		carRent.addNewRental(carRent.findCustomerByTLN("PK0967"), carRent.findCarByUTN("XNX9901"), rentDate, expDate,336.00f);





		//System-User interface
		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while (userOption!=6){ 
			printMenu();
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

			// Variables used to keep user input
			int freleaseYear,frentalPrice,fsumOfMiles,answer = 0,fyearsOfDrivingLisence;
			float favgFuelConsumption;					   						    
			String ffullName,fcarUTN,fcarBATM,fuserInput,fcustomerTLN,fcountryOfOrigin; 
			Date frentDate, fexpDate;
			switch (userOption) {

			case 1:	     // Insert New Car
				System.out.println();
				fcarUTN = reader.readString("Give me Car unique traffic number:");
				fcarBATM = reader.readString("Give me brand and traffic model:");
				freleaseYear=reader.readPositiveInt("Give me year of release");
				frentalPrice= reader.readPositiveInt("Give me car's rental price:");
				favgFuelConsumption= reader.readPositiveFloat("Give me car's average fuel consumption per 100km");
				fsumOfMiles= reader.readPositiveInt("Give me sum of miles by the car:"); 
				carRent.addCar(new Car(fcarUTN, fcarBATM, freleaseYear, frentalPrice,favgFuelConsumption, fsumOfMiles));


				System.out.println();
				System.out.println("Choose what Feature you want to add");
				System.out.println("=================================================================");
				System.out.println("1. Air Condition.................................................");
				System.out.println("2. Automatic.....................................................");
				System.out.println("3. Diesel........................................................");
				System.out.println("4. Hybrid........................................................");
				System.out.println("5. Leather Seats.................................................");
				System.out.println("6. Four Wheel Drive .............................................");
				System.out.println("7. Seven Seats...................................................");
				System.out.println("8. Cabriolet.....................................................");
				System.out.println("9. Exit..........................................................");
				System.out.println("=================================================================\n");


				System.out.println("Give me Features: ");
				while ( answer !=9 ) {

					fuserInput = reader.readString("");
					answer=0;
					if (fuserInput == null) {
						continue;
					} else {
						try {
							answer = Integer.parseInt(fuserInput);
						} catch (NumberFormatException ex) {
							answer = 0;
						}
					}
					switch (answer) {
					case 1:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.AIR_CONDITION);
						break;
					case 2:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.AUTOMATIC);
						break;
					case 3:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.DIESEL);
						break;
					case 4:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.HYBRID);
						break;
					case 5:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.LEATHER_SEATS);
						break;
					case 6:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.FOUR_WHEEL_DRIVE);
						break;
					case 7:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.SEVEN_SEATS);
						break;
					case 8:
						carRent.findCarByUTN(fcarUTN).addFeature(Features.CABRIOLET);
						break;
					case 9:
						break;
					default:
						System.out.println("Invalid Choise. Please Try again.");
						continue;

					}
				}
				reader.readString("Press enter  to continue...");
				break;

			case 2:
				carRent.printCarsCatalogue();
				reader.readString("Press enter to continue...");
				break;

			case 3:	  // Insert New Customer
				System.out.println();
				ffullName = reader.readString("Give me customer's full name:");
				fcustomerTLN = reader.readString("Give me customer's traffic lisence number:");
				fcountryOfOrigin = reader.readString ("Give me customer's country of origin:");
				fyearsOfDrivingLisence= reader.readPositiveInt("Give me customer's years of driving lisence:");
				carRent.addCustomer(new Customer(ffullName, fcustomerTLN, fcountryOfOrigin,fyearsOfDrivingLisence));
				reader.readString("Press enter to continue...");
				break;

			case 4:  //Add New Rental
				System.out.println();
				int choice;
				int discPer=0;
				fcustomerTLN = reader.readString("Give me The driver's traffic lisence number:");
				fcarUTN = reader.readString("Give me The car unique traffic number:");
				frentDate= reader.readDate("Give me the rental date:");
				fexpDate= reader.readDate("Give me the expiration date:");
				choice = reader.readPositiveInt("If you have a discount press 1 ,else press any other key.");
				if (choice==1)
				{
					do {
						discPer=reader.readPositiveInt("What is the percentage of the discount?");
						if(discPer>100 || discPer<0 )
							System.out.println("The discount has to be from 1-99%");}
					while( discPer>100 || discPer<0);

					carRent.addNewRental(carRent.findCustomerByTLN(fcustomerTLN), carRent.findCarByUTN(fcarUTN), frentDate, fexpDate,discPer);
				}
				else 
					carRent.addNewRental(carRent.findCustomerByTLN(fcustomerTLN), carRent.findCarByUTN(fcarUTN), frentDate, fexpDate,discPer);
				reader.readString("Press enter to continue...");
				break; 

			case 5:	//Print Rental Informations	  
				System.out.println();
				System.out.println("=======================================================================================");
				System.out.println("1. Print informations for a car's rental...............................................");
				System.out.println("2. Print informations for a customer's rental..........................................");
				System.out.println("3. Print informations for a particular period of time..................................");
				System.out.println("=======================================================================================");

				fuserInput = reader.readString("What information are you looking for? ");
				answer=0;
				if (fuserInput == null) {
					continue;
				} else {
					try {
						answer = Integer.parseInt(fuserInput);
					} catch (NumberFormatException ex) {
						answer = 0;
					}
				}

				switch (answer) {
				case 1: //	For Car
					System.out.println();
					fcarUTN = reader.readString("Give me The car code:");
					Car car= carRent.findCarByUTN(fcarUTN);
					carRent.printCarInfo(car);
					reader.readString("Press any key to continue...");
					break;
				case 2:	//	For Customer
					System.out.println();
					fcustomerTLN = reader.readString("Give me The driver's license:");
					Customer cust= carRent.findCustomerByTLN(fcustomerTLN);
					carRent.printCustomerInfo(cust);
					reader.readString("Press any key to continue...");
					break;
				case 3:	//	For Date Period
					System.out.println();
					frentDate= reader.readDate("Give me the rental date:");
					fexpDate= reader.readDate("Give me the expiration date:");
					DatePeriod period= new DatePeriod(frentDate, fexpDate);
					carRent.printDateInfo(period);
					reader.readString("Press any key to continue...");
					break;
				default: 
					continue;
				}

			case 6:      
				System.out.println();
				System.out.println("Thanks for using the carRentCompany...");
				break;	                
			default:	
				System.out.println();
				System.out.println("User option " + userOption + " not valid...");
				continue;
			}
		}
	}


	public static void printMenu() {
		System.out.println("               Car Company Console"                     );
		System.out.println("=======================================================");
		System.out.println("1. Insert New Car......................................");
		System.out.println("2. Print All Cars......................................");
		System.out.println("3. Insert a Customer...................................");
		System.out.println("4. Add New Rental......................................");
		System.out.println("5. Print Rental Informations...........................");
		System.out.println("6. Exit................................................"); 
		System.out.println("=======================================================");        
	}
}


