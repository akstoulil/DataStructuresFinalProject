
public class Employee {
	
	private int key;
	private String firstName;
	private String lastName;
	private double weeklyPay;
	private double balance;
	private Employee next;

	public Employee(){
		
	}
	
	public Employee(int key, String firstName, String lastName, double weeklyPay, double balance){
		
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyPay = weeklyPay;
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

	public double getWeeklyPay() {
		return weeklyPay;
	}

	public void setWeeklyPay(double weeklyPay) {
		this.weeklyPay = weeklyPay;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Employee getNext() {
		return next;
	}

	public void setNext(Employee next) {
		this.next = next;
	}
	
	
	public void addFunds(double amount){
		
		balance += amount;
		
	}
	
	public void withdrawExternalFunds(double amount){
		
		balance -= amount;
		
	}
	
	public void displayInfo(){
		
		System.out.println("Employee Key: " + getKey() + " || First Name: " + getFirstName() + " || Last Name: " + getLastName()
		+ "\nWeekly Pay: " + getWeeklyPay() + " || Current Balance: " + getBalance());
		
	}

}
