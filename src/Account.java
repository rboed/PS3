// PS3 Ryan Boedeker

import java.util.Date;

public class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	/**
	 * A no-arg constructor that creates a default account
	 */
	public Account(){
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	/**
	 * An account with the specified id and initial balance
	 * @param id account id
	 * @param balance initial account balance
	 */
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
	}
	
	//GETTERS
	
	/**
	 * Getter for id
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * Getter for balance
	 * @return balance
	 */
	public double getBalance(){
		return this.balance;
	}
	
	/**
	 * Getter for annualInterestRate
	 * @return annualInterestRate
	 */
	public double getAnnualInterestRate(){
		return this.annualInterestRate;
	}
	
	/**
	 * Getter for dateCreated
	 * @return dateCreated
	 */
	public Date getDateCreated(){
		return this.dateCreated;
	}
	
	/**
	 * Calculates and returns the monthly interest rate from the annualInterestRate
	 * @return monthly interest rate
	 */
	public double getMonthlyInterestRate(){
		return this.annualInterestRate * (1 / 12);
	}
	
	//SETTERS
	
	/**
	 * Setter for id
	 * @param id id that will be set
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * Setter for balance
	 * @param balance balance that will be set
	 */
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	/**
	 * Setter for annualInterestRate
	 * @param annualInterestRate annualInterestRate that will be set
	 */
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	// note for self:Subtract AND assignment operator, It subtracts right
	// operand from the left operand and assign the result to left operand
	
	// "Throws clause is used to declare the exceptions that are not handled 
	// by a particular method and is an instruction to the callers to either
	// handle these explicitly or rethrow them up in the call hierarchy."
	
	/**
	 * Withdraw specifiedAmount
	 * @param specifiedAmount amount withdrawn
	 * @throws InsufficeintFundsException if Specified amount is greater than balance
	 */
	public void withdraw(double specifiedAmount) throws InsufficientFundsException{
		if(specifiedAmount < 0.00){
			return;
		}
		if(specifiedAmount <= balance){
			this.balance -= specifiedAmount;
		}
		else{
			throw new InsufficientFundsException(specifiedAmount - balance);
		}
	}
	
	// Notes for self: += add AND assignment operator, It adds right 
	// operand to the left operand and assign the result to left operand
	
	/**
	 * "deposit" specifiedAmount as long as it is not a negative amount
	 * @param specifiedAmount amount to deposit
	 */
	public void deposit(double specifiedAmount){
		if(specifiedAmount < 0.00){
			return;
		}
		this.balance += specifiedAmount;
	}
}