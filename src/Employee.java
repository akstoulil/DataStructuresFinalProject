
/**
 * This class holds an employee's information
 * @author Austin Stoulil
 *
 */
public class Employee {
	
	//Instance variables for the id, first name, last name, occupation, hourly pay rate, and personal balance
	private int key;
	private String firstName;
	private String lastName;
	private String occupation;
	private double hourlyPay;
	private double balance;
	
	/**
	 * This is the default constructor that sets all of the values to null by default
	 */
	public Employee(){
		
	}
	
	/**
	 * This is the parameterized constructor for the Employee class
	 * @param key The employee's ID number
	 * @param firstName The employee's first name
	 * @param lastName The employee's last name
	 * @param occupation The employee's occupation
	 * @param hourlyPay The employee's hourly pay rate
	 * @param balance The employee's personal balance
	 */
	public Employee(int key, String firstName, String lastName, String occupation, double hourlyPay, double balance){
		
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.hourlyPay = hourlyPay;
		this.balance = balance;
		
	}
	
	/**
	 * This method gets the ID number of the employee
	 * @return Returns the ID number
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * This method sets the ID number of the employee
	 * @param key The new ID number of the employee
	 */
	public void setKey(int key) {
		this.key = key;
	}
	
	/**
	 * This method gets the first name of the employee
	 * @return Returns the first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method sets the first name of the employee
	 * @param firstName The new first name of the employee
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This method gets the last name of the employee
	 * @return Returns the employee's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method sets the last name of the employee
	 * @param lastName The new last name of the employee
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This method gets the occupation of the employee
	 * @return Returns the employee's occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	
	/**
	 * This method sets the employee's occupation
	 * @param occupation The new occupation for the employee
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	/**
	 * This method gets the hourly pay rate of the employee
	 * @return Returns the hourly pay rate of the employee
	 */
	public double getHourlyPay() {
		return hourlyPay;
	}
	
	/**
	 * This method sets the hourly pay rate of the employee
	 * @param hourlyPay The new hourly pay rate for the employee
	 */
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	
	/**
	 * This method gets the employee's personal balance
	 * @return Returns the employee's personal balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * This method sets the personal balance of the employee
	 * @param balance The employee's personal balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * This method adds funds to the employee's balance
	 * @param amount The amount of funds to add
	 */
	public void addFunds(double amount){
		
		balance += amount;
		
	}
	
	/**
	 * This method withdraws funds from the employee's personal balance
	 * @param amount The amount of funds to withdraw
	 */
	public void withdrawExternalFunds(double amount){
		
		balance -= amount;
		
	}
	
	/**
	 * This method displays all of the employee's information
	 */
	public void displayInfo(){
		
		//Program prints out the employee's information
		System.out.println("Employee Key: " + getKey() + " || First Name: " + getFirstName() + " || Last Name: " + getLastName()
		+ "\n Occupation: " + getOccupation() + " || Weekly Pay: " + getHourlyPay() + " || Current Balance: " + getBalance());
		
	}

}
