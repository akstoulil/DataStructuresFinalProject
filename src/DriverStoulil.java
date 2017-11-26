import java.util.Scanner;

/**
 * The main driver of the program
 * @author Austin Stoulil
 *
 */
public class DriverStoulil {
	
	public static void main(String[] args){
		
		//Creating variables for controlling the while loop, the scanner, and one for the CompanyList
		Scanner in = new Scanner(System.in);
		boolean finished = false;
		CompanyList c = new CompanyList();
		
		//While loop to set up the menu
		while(finished == false){
			
			//Program displays a list of the available options to choose from, and prompts the user to enter a choice
			System.out.println("-----------------------------");
			System.out.println("Please choose a selection from the available options:");
			System.out.println("Enter 1 to add an employee");
			System.out.println("Enter 2 to remove an employee");
			System.out.println("Enter 3 to search for an employee");
			System.out.println("Enter 4 to add funds to the company");
			System.out.println("Enter 5 to withdraw funds from the company");
			System.out.println("Enter 6 to display the company's funds");
			System.out.println("Enter 7 to pay an employee");
			System.out.println("Enter 8 to set an employee's pay rate");
			System.out.println("Enter 9 to display a list of all employees");
			System.out.println("Enter 10 to display the number of all employees");
			System.out.println("Enter 11 to update an employee's information");
			System.out.println("Enter 12 to sort the employees by their ID numbers");
			System.out.println("Enter 13 to exit the program");
			
			//Setting up a try/catch block to handle exceptions
			try{
				
				//Program prompts the user to enter their choice
				System.out.print("Please enter your choice: ");
				int choice = in.nextInt();
				System.out.println("-----------------------------");
				
				//If the choice was one
				if(choice == 1){
					
					//Program prompts the user to enter the employee's information
					System.out.print("Enter the employee's id: ");
					int id = in.nextInt();
					
					System.out.print("Enter the employee's first name: ");
					String firstName = in.next();
					
					System.out.print("Enter the employee's last name: ");
					String lastName = in.next();
					
					System.out.print("Enter the employee's occupation: ");
					String occupation = in.next();
					
					System.out.print("Enter the employee's hourly pay rate: ");
					double payRate = in.nextDouble();
					
					System.out.print("Enter the employee's personal balance: ");
					double balance = in.nextDouble();
					
					//Program creates a new employee with the input and inserts it into the CompanyList
					Employee e = new Employee(id, firstName, lastName, occupation, payRate, balance);
					c.insert(e);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 2){
					
					//Program prompts the user for the ID of the employee to be removed
					System.out.print("Enter the ID of the employee to be removed: ");
					int id = in.nextInt();
					
					//Program removes the employee from the CompanyList
					c.removeEmployee(id);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 3){
					
					//Program prompts the user for the ID of the employee to search for
					System.out.print("Enter the ID of the employee to search for: ");
					int id = in.nextInt();
					
					//Program finds and displays the employee's information
					c.findEmployee(id);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 4){
					
					//Program prompts the user for the amount of funds to add
					System.out.print("Enter the amount of funds to add: ");
					double amount = in.nextDouble();
					
					//Program adds the funds
					c.addCompanyFunds(amount);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 5){
					
					//Program prompts the user for the amount of funds to withdraw
					System.out.print("Enter the amount of funds to withdraw: ");
					double amount = in.nextDouble();
					
					//Program withdraws the funds
					c.withdrawCompanyFunds(amount);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 6){
					
					//Program displays the company's funds
					System.out.println("Total company funds: $" + c.getCompanyBalance());
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 7){
					
					//Program prompts for the ID of the employee to pay
					System.out.print("Enter the ID fo the employee to pay: ");
					int id = in.nextInt();
					
					//Program pays the specified employee
					c.payEmployee(id);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 8){
					
					//Program prompts for the ID of the employee
					System.out.print("Enter the ID of the employee: ");
					int id = in.nextInt();
					
					//Program prompts for the new pay rate
					System.out.println("Enter the new pay rate: ");
					double payRate = in.nextDouble();
					
					//Program sets the new pay rate
					c.setPayRate(id, payRate);
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 9){
					
					//Program displays a list of all of the current employees
					c.displayEmployees();
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 10){
					
					//Program displays the number of employees with the company
					c.numberOfEmployees();
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 11){
					
					//Program updates the employee's information
					c.updateEmployee();
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 12){
					
					//Program sorts the employee's by their ID numbers in ascending order using a selection sort
					c.sortByID();
					
					//Program asks the user if they want to continue editing
					System.out.print("Continue editing? Type y for yes, n for no: ");
					String cont = in.next();
					
					//If not, then end the program
					if(cont.equals("n") || cont.equals("N")){
						
						finished = true;
						
					}
					
				} else if(choice == 13){
					
					//End the program
					finished = true;
					
				} else {
					
					//End the program
					finished = true;
					
				}
				
			} catch(Exception e){
				
				//Program displays an error message
				System.out.println("Error, data was entered");
				finished = true;
				
			}
			
		}
		
		//Closing the scanner
		in.close();
		
	}

}
