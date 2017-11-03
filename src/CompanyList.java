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

}
