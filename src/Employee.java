
public class Employee {
	
	private int key;
	private String firstName;
	private String lastName;
	private double hourlyPay;
	private double balance;

	public Employee(){
		
	}
	
	public Employee(int key, String firstName, String lastName, double hourlyPay, double balance){
		
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyPay = hourlyPay;
		this.balance = balance;
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public void addFunds(double amount){
		
		balance += amount;
		
	}
	
	public void withdrawExternalFunds(double amount){
		
		balance -= amount;
		
	}
	
	public void displayInfo(){
		
		System.out.println("Employee Key: " + getKey() + " || First Name: " + getFirstName() + " || Last Name: " + getLastName()
		+ "\nWeekly Pay: " + getHourlyPay() + " || Current Balance: " + getBalance());
		
	}

}
