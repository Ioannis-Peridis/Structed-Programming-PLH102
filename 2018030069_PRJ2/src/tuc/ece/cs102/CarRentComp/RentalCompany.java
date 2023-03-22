package tuc.ece.cs102.CarRentComp;

import java.util.Vector;
import java.util.Date;
import tuc.ece.cs102.util.*;
import java.text.SimpleDateFormat;

public class RentalCompany {
	private String name;
	private int afm;
	private String hydra;

	private Vector<Car> listOfCars;
	private Vector<Rental> listOfRentals;
	private Vector<Customer> listOfCustomers;

	int rentalCode=100;

	/*class constructors*/
	public RentalCompany() {
		listOfCars=new Vector<Car>();
		listOfRentals=new Vector<Rental>();
		listOfCustomers=new Vector<Customer>();

	}

	public RentalCompany(String name,int afm,String hydra) {
		this.name=name;
		this.afm=afm;
		this.hydra=hydra;
		listOfCars=new Vector<Car>();
		listOfRentals=new Vector<Rental>();
		listOfCustomers=new Vector<Customer>();

	}
	/*getters and setters*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAfm() {
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


	public Vector<Car> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(Vector<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	public Vector<Rental> getListOfRentals() {
		return listOfRentals;
	}

	public void setListOfRentals(Vector<Rental> listOfRentals) {
		this.listOfRentals = listOfRentals;
	}

	public Vector<Customer> getListOfCustomers() {
		return listOfCustomers;
	}

	public void setListOfCustomers(Vector<Customer> listOfCustomers) {
		this.listOfCustomers = listOfCustomers;
	}


	public int getRentCode() {
		return rentalCode;
	}

	public void setRentCode(int rentCode) {
		this.rentalCode = rentCode;
	}

	/*adds a car/customer/rentals to the list of cars/customers/rentals */
	public void addCar(Car c) {
		listOfCars.add(c);
	}

	public void addCustomer(Customer c) {
		listOfCustomers.add(c);

	}

	public void addRental(Rental r) {
		listOfRentals.add(r);
	}


	//makes new rental


	public void addNewRental (Customer customer, Car car, Date rentDate, Date expDate,int discPer) { 
		if (customer!=null && car!=null) {
			int counter=0;
			DatePeriod period= new DatePeriod(rentDate, expDate);
			for (int i=0 ; i<car.getCarRentals().size(); i++) {
				if (period.overlaps(car.getCarRentals().get(i).getRentDur()))
					counter++;
			}
			if (counter>0) {
				System.out.println("The car:"+car.getBrandAndTrafficModel()+ "will not be available at this period of time, please Select another one.");
			}
			else { 
				Rental r =  new Rental(customer,car,rentDate,expDate);
				r.setRentalCode(rentalCode);
				r.setTotalRentalPrice(TotalRentalPrice(rentDate, expDate,car,discPer));
				addRental(r);//update car,customer,rental objects
				car.addCarRental(r);
				customer.addCustomerRental(r);
				rentalCode++;

			}}

		else System.out.println("Error: Undefined Customer or Car...");

	}


	public void addNewRental (Customer customer, Car car, Date rentDate, Date expDate,float totalRentalPrice) { 
		if (customer!=null && car!=null) {
			int counter=0;
			DatePeriod period= new DatePeriod(rentDate, expDate);
			for (int i=0 ; i<car.getCarRentals().size(); i++) {
				if (period.overlaps(car.getCarRentals().get(i).getRentDur()))
					counter++;
			}
			if (counter>0) {
				System.out.println("The car:"+car.getBrandAndTrafficModel()+ "will not be available at this period of time, please Select another one.");
			}
			else { 
				Rental r =  new Rental(customer,car,rentDate,expDate);
				r.setRentalCode(rentalCode);
				r.setTotalRentalPrice(totalRentalPrice);
				addRental(r);//update car,customer,rental objects
				car.addCarRental(r);
				customer.addCustomerRental(r);
				rentalCode++;

			}
		}
		else System.out.println("Error: Undefined Customer or Car...");

	}



	//method used to calculate the total rental price
	public float TotalRentalPrice(Date rentDate, Date expDate,Car c, int discPer) {
		DatePeriod period=new DatePeriod(rentDate,expDate);
		int diffInDays=period.toDays();//method toDays calculates the difference between the expDate and the rentDate
		float  totalRentalPrice=(100-discPer)*diffInDays*c.getRentalPrice()/100;
		return totalRentalPrice;
	}



	//find a customer by the traffic license number
	public Customer findCustomerByTLN(String dln) {
		for(int i=0;i<this.listOfCustomers.size();i++) {
			if(this.listOfCustomers.get(i).getDrivingLicenseNumber().equals(dln)) {
				return listOfCustomers.get(i);

			}
		}return null;

	}
	//find car by the unique traffic number
	public Car findCarByUTN(String utn) {
		for(int i=0;i<this.listOfCars.size();i++) {
			if(listOfCars.get(i).getUniqueTrafficNumber().equals(utn)) {
				return listOfCars.get(i);
			}
		}return null;

	}



	//prints all cars
	public void printCarsCatalogue(){
		for (int i=0; i<this.listOfCars.size();i++){
			this.listOfCars.get(i).println();
		}
	}

	//prints car information
	public void printCarInfo(Car car) {
		for (int i=0; i<car.getCarRentals().size(); i++) {
			System.out.println("");
			System.out.println("Rental number: " + (i+1) + " of the Car with unique traffic number: "+ car.getUniqueTrafficNumber());
			car.getCarRentals().get(i).println();
		}
	}

	//prints customer informations
	public void printCustomerInfo(Customer cust) {
		for (int i=0; i<cust.getCustomerRentals().size(); i++) {
			System.out.println("");
			System.out.println("Rental number: " + (i+1) + " of the Customer with driving license number: " + cust.getDrivingLicenseNumber());
			cust.getCustomerRentals().get(i).println();
		}
	}
	//prints date informations
	public void printDateInfo (DatePeriod period) {
		System.out.print("There are: ");
		int count=0;
		for (int i=0 ; i<listOfRentals.size(); i++) {
			if (period.overlaps(listOfRentals.get(i).getRentDur())) {
				count++;
				System.out.println();
				System.out.print(count + ".	");
				listOfRentals.get(i).print();

			}
		} 

		if (count==0)
			System.out.println("no rentals at this period of time.");
		System.out.println();
	}


	// function that converts a Date to String
	public  Date StringToDate(String s) {
		Date d=new Date();
		try {
			SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
			d=sdf1.parse(s);
			return d;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}



