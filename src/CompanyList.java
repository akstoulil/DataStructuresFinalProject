import java.util.ArrayList;
import java.util.Scanner;

public class CompanyList {
	
	private ArrayList<Employee> employees;
	private double companyBalance;
	private Scanner in;
	
	public CompanyList(){
		
		employees = new ArrayList<Employee>();
		companyBalance = 1000000;
		in = new Scanner(System.in);
		
	}
	
	public CompanyList(double companyBalance){
		
		employees = new ArrayList<Employee>();
		this.companyBalance = companyBalance;
		in = new Scanner(System.in);
		
	}
	
	public double getCompanyBalance() {
		return companyBalance;
	}

	public void setCompanyBalance(double companyBalance) {
		this.companyBalance = companyBalance;
	}

	public boolean isEmpty(){
		
		return employees.isEmpty();
		
	}
	
	public void insert(Employee emp){
		
		boolean valid = true;
		
		for(int i = 0; i < employees.size(); i++){
			
			if(emp.getKey() == employees.get(i).getKey()){
				
				System.out.println("Error, this key already exists within the list. Please enter a different key.");
				valid = false;
				break;
				
			}
		}
		
		if(valid == true){
			
			employees.add(emp);
			System.out.println("Employee " + emp.getFirstName() + " was successfully inserted.");
			
		}
		
	}
	
	public void findEmployee(int key){
		
		boolean found = false;
		
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getKey() == key){
				
				found = true;
				System.out.println("Employee with key " + key + " was found.");
				employees.get(i).displayInfo();
				break;
				
			}
		}
		
		if(found == false){
			
			System.out.println("Error, employee with key " + key + " was not found within the list.");
			
		}
		
	}
	
	public void removeEmployee(int key){
		
		boolean found = false;
		
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getKey() == key){
				
				found = true;
				System.out.println("Employee with key " + key + " was successfully removed.");
				break;
				
			}
		}
		
		if(found == false){
			
			System.out.println("Error, employee with key " + key + " was not found within the list.");
			
		}
		
	}
	
	public void addCompanyFunds(double amount){
		
		if(amount > 0){
			
			companyBalance += amount;
			
		} else {
			
			System.out.println("Error, funds to be added must be greater than zero");
			
		}
		
	}
	
	public void withdrawCompanyFunds(double amount){
		
		if(amount > 0){
			
			companyBalance -= amount;
			
		} else {
			
			System.out.println("Error, funds to be withdrawn must be greater than zero");
			
		}
		
	}
	
	public void payEmployee(int key){
		
		boolean found = false;
		
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getKey() == key){
				
				found = true;
				System.out.println("Please enter how many hours employee " + key + " has worked: ");
				double hours = in.nextDouble();
				
				if(hours > 0){
					
					double pay = hours * employees.get(i).getHourlyPay();
					companyBalance -= pay;
					employees.get(i).addFunds(pay);
					
				} else if(hours > 40){
					
					double extraHours = hours - 40;
					double normalHours = hours - extraHours;
					double overtime = extraHours * (employees.get(i).getHourlyPay() * 1.5);
					double pay = normalHours * employees.get(i).getHourlyPay();
					double total = pay + overtime;
					
					companyBalance -= total;
					employees.get(i).addFunds(total);
					
				} else {
					
					System.out.println("Error, hours worked must be greater than zero.");
					
				}
				
			}
		}
		
		if(found == false){
			
			System.out.println("Error, employee " + key + " was not found in the list.");
			
		}
		
	}
	
	public void setPayRate(int key, double payRate){
		
		boolean found = false;
		
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getKey() == key){
				
				found = true;
				
				if(payRate > 0){
					
					employees.get(i).setHourlyPay(payRate);
					System.out.println("Payrate successfully updated.");
					
				} else {
					
					System.out.println("Error, payrate must be greater than zero.");
					
				}
			}
		}
		
		if(found == false){
			
			System.out.println("Error, employee " + key + " was not found in the list.");
			
		}
	}
	
	public void displayEmployees(){
		
		for(int i = 0; i < employees.size(); i++){
			
			employees.get(i).displayInfo();
			System.out.println("------------------------------");
			
		}
	}
	
	public void numberOfEmployees(){
		
		int total = 0;
		
		for(int i = 0; i < employees.size(); i++){
			
			total++;
			
		}
		
		System.out.println("Total Number Of Employees In The List: " + total);
		
	}
	
	public void updateEmployee(){
		
		System.out.print("Please enter the employee id of the employee to update: ");
		int id = in.nextInt();
		
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getKey() == id){
				
				System.out.println("Please enter an available number from the list of available options:");
				System.out.println("Enter 1 to update the employee's first name");
				System.out.println("Enter 2 to update the employee's last name");
				System.out.println("Enter 3 to update the employee's occupation");
				
				int choice = in.nextInt();
				
				if(choice == 1){
					
					System.out.println("Please enter the new first name: ");
					String firstName = in.next();
					
					employees.get(i).setFirstName(firstName);
					System.out.println("First name successfully updated");
					
				} else if(choice == 2){
					
					System.out.println("Please enter the new last name: ");
					String lastName = in.next();
					
					employees.get(i).setLastName(lastName);
					System.out.println("Last name successfully updated");
					
				} else if(choice == 3){
					
					System.out.println("Please enter the new occupation for the employee: ");
					String occupation = in.next();
					
					employees.get(i).setOccupation(occupation);
					System.out.println("Occupation successfully updated");
					
				} else {
					
					System.out.println("Error, number entered was not one of the available choices");
					
				}
			}
		}
	}
	
	public void sortByID(){
		
		int out, in, min;
		
		for(out = 0; out < employees.size(); out++){
			
			min = out;
			
			for(in = out + 1; in < employees.size(); in++){
				
				if(employees.get(in).getKey() < employees.get(min).getKey()){
					
					min = in;
					swap(out, min);
					
				}
			}
		}
	}
	
	public void swap(int one, int two){
		
		Employee temp = employees.get(one);
		employees.set(one, employees.get(two));
		employees.set(two, temp);
		
	}

}
