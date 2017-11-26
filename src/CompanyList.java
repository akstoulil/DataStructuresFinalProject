import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class holds all of the employees, company balance, and methods to modify the data with
 * @author Austin Stoulil
 *
 */
public class CompanyList {
	
	//The instance variables
	private ArrayList<Employee> employees;
	private double companyBalance;
	private Scanner in;
	
	/**
	 * Default constructor. Initializes the variables and sets the company balance to 1000000
	 */
	public CompanyList(){
		
		employees = new ArrayList<Employee>();
		companyBalance = 1000000;
		in = new Scanner(System.in);
		
	}
	
	/**
	 * Parameterized constructor that accepts an argument for the company balance
	 * @param companyBalance This parameter initializes the company balance with a specified amount
	 */
	public CompanyList(double companyBalance){
		
		employees = new ArrayList<Employee>();
		this.companyBalance = companyBalance;
		in = new Scanner(System.in);
		
	}
	
	/**
	 * Getter for the company balance
	 * @return Returns the company's balance
	 */
	public double getCompanyBalance() {
		return companyBalance;
	}
	
	/**
	 * Setter for the company balance
	 * @param companyBalance The amount of money to set the company balance to
	 */
	public void setCompanyBalance(double companyBalance) {
		this.companyBalance = companyBalance;
	}
	
	/**
	 * This method checks if the ArrayList is empty
	 * @return Returns a boolean for if the ArrayList is empty or not
	 */
	public boolean isEmpty(){
		
		return employees.isEmpty();
		
	}
	
	/**
	 * This method inserts an employee into the ArrayList
	 * @param emp This parameter is the employee object to be inserted
	 */
	public void insert(Employee emp){
		
		//Boolean to validate the employee with
		boolean valid = true;
		
		//For loop goes through the ArrayList
		for(int i = 0; i < employees.size(); i++){
			
			//If the key of the employee to be inserted is already within the list
			if(emp.getKey() == employees.get(i).getKey()){
				
				//Program prints out an error message, sets valid to false, and ends the loop
				System.out.println("Error, this key already exists within the list. Please enter a different key.");
				valid = false;
				break;
				
			}
		}
		
		//If the employee entered is valid
		if(valid == true){
			
			//Program adds the employee and displays that the employee was successfully inserted
			employees.add(emp);
			System.out.println("Employee " + emp.getFirstName() + " was successfully inserted.");
			
		}
		
	}
	
	/**
	 * This method searches for an employee in the list by their ID number
	 * @param key This is the ID of the employee to search for
	 */
	public void findEmployee(int key){
		
		//Boolean to check if the employee was found
		boolean found = false;
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//If the specified key is found
			if(employees.get(i).getKey() == key){
				
				//Set found to true, display that the employee was found, and display the employee's information
				found = true;
				System.out.println("Employee with key " + key + " was found.");
				employees.get(i).displayInfo();
				break;
				
			}
		}
		
		//If the employee was not found
		if(found == false){
			
			//Program displays an error message indicating that the employee was not found
			System.out.println("Error, employee with key " + key + " was not found within the list.");
			
		}
		
	}
	
	/**
	 * This method removes an employee from the array list
	 * @param key The ID of the employee to be removed
	 */
	public void removeEmployee(int key){
		
		//Boolean to check if the employee was found
		boolean found = false;
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//If the specified key is found
			if(employees.get(i).getKey() == key){
				
				//Set found to true, display that the employee was found, and remove the employee
				found = true;
				System.out.println("Employee with key " + key + " was successfully removed.");
				employees.remove(i);
				break;
				
			}
		}
		
		//If the employee was not found
		if(found == false){
			
			//Program displays an error message indicating that the employee was not found
			System.out.println("Error, employee with key " + key + " was not found within the list.");
			
		}
		
	}
	
	/**
	 * This method adds funds to the company balance
	 * @param amount The amount of funds to add
	 */
	public void addCompanyFunds(double amount){
		
		//If the amount is greater than zero
		if(amount > 0){
			
			//Adds the funds
			companyBalance += amount;
			
		} else {
			
			//Program displays an error message indicating that the amount must be greater than zero
			System.out.println("Error, funds to be added must be greater than zero");
			
		}
		
	}
	
	/**
	 * This method withdraws funds from the company balance
	 * @param amount The amount of funds to withdraw
	 */
	public void withdrawCompanyFunds(double amount){
		
		//If the amount entered is greater than zero
		if(amount > 0){
			
			//Withdraw the amount
			companyBalance -= amount;
			
		} else {
			
			//Program displays an error message
			System.out.println("Error, funds to be withdrawn must be greater than zero");
			
		}
		
	}
	
	/**
	 * This method withdraws funds from the company funds in order to pay employees for their hours worked
	 * @param key The ID of the employee to pay
	 */
	public void payEmployee(int key){
		
		//Boolean to check if the employee was found
		boolean found = false;
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//If the employee was found
			if(employees.get(i).getKey() == key){
				
				//Set found to true, and prompt for the hours worked
				found = true;
				System.out.println("Please enter how many hours employee " + key + " has worked: ");
				double hours = in.nextDouble();
				
				//If hours worked is greater than zero
				if(hours > 0){
					
					//Program calculates the pay, and pays the employee
					double pay = hours * employees.get(i).getHourlyPay();
					companyBalance -= pay;
					employees.get(i).addFunds(pay);
					
				} else if(hours > 40){
					
					//Program calculates the pay with overtime pay, and then pays the employee
					double extraHours = hours - 40;
					double normalHours = hours - extraHours;
					double overtime = extraHours * (employees.get(i).getHourlyPay() * 1.5);
					double pay = normalHours * employees.get(i).getHourlyPay();
					double total = pay + overtime;
					
					companyBalance -= total;
					employees.get(i).addFunds(total);
					
				} else {
					
					//Program displays an error message indicating that the hours worked must be greater than zero
					System.out.println("Error, hours worked must be greater than zero.");
					
				}
				
			}
		}
		
		//If the employee was not found
		if(found == false){
			
			//Program displays an error message indicating that the employee was not found
			System.out.println("Error, employee " + key + " was not found in the list.");
			
		}
		
	}
	
	/**
	 * This method sets the pay rate of an employee
	 * @param key The ID of the employee to modify
	 * @param payRate The new pay rate of the employee being modified
	 */
	public void setPayRate(int key, double payRate){
		
		//Boolean that checks if the employee was found
		boolean found = false;
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//If the employee was found
			if(employees.get(i).getKey() == key){
				
				//Set found to true
				found = true;
				
				//If the new pay rate is greater than zero
				if(payRate > 0){
					
					//Program sets the hourly pay rate and displays that it was successfully updated
					employees.get(i).setHourlyPay(payRate);
					System.out.println("Payrate successfully updated.");
					
				} else {
					
					//Program displays an error message saying that the pay rate must be greater than zero
					System.out.println("Error, payrate must be greater than zero.");
					
				}
			}
		}
		
		//If the employee was not found
		if(found == false){
			
			//Program prints out an error message indicating that the employee was not found
			System.out.println("Error, employee " + key + " was not found in the list.");
			
		}
	}
	
	/**
	 * This method displays all of the employees in the array list
	 */
	public void displayEmployees(){
		
		//If there are employees in the array list
		if(employees.size() > 0){
			
			//For loop goes through the array list
			for(int i = 0; i < employees.size(); i++){
				
				//Program displays the employee's information
				employees.get(i).displayInfo();
				System.out.println("------------------------------");
				
			}
			
		} else {
			
			//Program displays a message indicating that there are no employees in the list
			System.out.println("There are no employees in the list");
			
		}
		
	}
	
	/**
	 * This method displays the total number of employees within the array list
	 */
	public void numberOfEmployees(){
		
		//Variable to keep a running total
		int total = 0;
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//Program increments the total by one
			total++;
			
		}
		
		//Program displays the total number of employees in the list
		System.out.println("Total Number Of Employees In The List: " + total);
		
	}
	
	/**
	 * This method allows the user to update an existing employee's information
	 */
	public void updateEmployee(){
		
		//Program prompts the user for the ID of the employee to update
		System.out.print("Please enter the employee id of the employee to update: ");
		int id = in.nextInt();
		
		//For loop goes through the array list
		for(int i = 0; i < employees.size(); i++){
			
			//If the employee is found
			if(employees.get(i).getKey() == id){
				
				//Program displays a list of the available options for updating
				System.out.println("Please enter an available number from the list of available options:");
				System.out.println("Enter 1 to update the employee's first name");
				System.out.println("Enter 2 to update the employee's last name");
				System.out.println("Enter 3 to update the employee's occupation");
				
				//Program prompts the user to enter a choice
				System.out.print("Please enter your update choice: ");
				int choice = in.nextInt();
				
				//If the choice equals one
				if(choice == 1){
					
					//Program prompts the user for the new first name
					System.out.println("Please enter the new first name: ");
					String firstName = in.next();
					
					//Program updates the employee
					employees.get(i).setFirstName(firstName);
					System.out.println("First name successfully updated");
					
				} else if(choice == 2){
					
					//Program prompts the user for the new last name
					System.out.println("Please enter the new last name: ");
					String lastName = in.next();
					
					//Program updates the employee
					employees.get(i).setLastName(lastName);
					System.out.println("Last name successfully updated");
					
				} else if(choice == 3){
					
					//Program prompts the user for the new occupation
					System.out.println("Please enter the new occupation for the employee: ");
					String occupation = in.next();
					
					//Program updates the employee
					employees.get(i).setOccupation(occupation);
					System.out.println("Occupation successfully updated");
					
				} else {
					
					//Program displays an error message
					System.out.println("Error, number entered was not one of the available choices");
					
				}
			}
		}
	}
	
	/**
	 * This method uses a selection sort to sort the employees in the list in ascending order by their ID numbers
	 */
	public void sortByID(){
		
		//Variables for the outer loop, inner loop, and minimum value
		int out, in, min;
		
		//For loop goes through the array list
		for(out = 0; out < employees.size(); out++){
			
			//Minimum equals the outer loop control variable
			min = out;
			
			//Inner for loop goes through the array list
			for(in = out + 1; in < employees.size(); in++){
				
				//If the current employee id is less than the minimum id number
				if(employees.get(in).getKey() < employees.get(min).getKey()){
					
					//Set a new minimum and swap the employees
					min = in;
					swap(out, min);
					
				}
			}
		}
		
		//Program displays that the list was successfully sorted
		System.out.println("List successfully sorted");
		
	}
	
	/**
	 * This method swaps the positions of two employees
	 * @param one The position of the first employee
	 * @param two The position of the second employee
	 */
	public void swap(int one, int two){
		
		//Program swaps the places of the employees
		Employee temp = employees.get(one);
		employees.set(one, employees.get(two));
		employees.set(two, temp);
		
	}

}
