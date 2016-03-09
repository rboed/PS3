import static org.junit.Assert.*;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
	
	private static Account ryanAccount;
	private static Account rebeccaAccount;
	private static Account elizabethAccount;
	private static Account rachelAccount;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//ACCOUNTS TO USE FOR TESTING

	@Before
	public void setUp() throws Exception {
		ryanAccount = new Account();
		rebeccaAccount = new Account(1122, 20000);
		elizabethAccount = new Account (3, 1000);
		rachelAccount = new Account (4, 1);
		
		rebeccaAccount.setAnnualInterestRate(0.045);
		elizabethAccount.setAnnualInterestRate(0.2);
		rachelAccount.setAnnualInterestRate(0.3);	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	// TEST FOR GETTERS
	/**
	 * Test for getId
	 */
	@Test
	public void testGetId() {
		assertEquals(rebeccaAccount.getId(), 1122);
		assertEquals(elizabethAccount.getId(), 3);
		assertEquals(rachelAccount.getId(), 4);
	}
	
	/**
	 * Test for getBalance
	 */
	@Test
	public void testGetBalance() {
		assertEquals(rebeccaAccount.getBalance(), 20000, 0.01);
		assertEquals(elizabethAccount.getBalance(), 1000, 1);
		assertEquals(rachelAccount.getBalance(), 1, 1);
	}
	
	/**
	 * Test for getAnnualInterestRate
	 */
	@Test
	public void testGetAnnualInterestRate() {
		assertEquals(rebeccaAccount.getAnnualInterestRate(), 0.045, .01);
		assertEquals(elizabethAccount.getAnnualInterestRate(), .2, 1);
		assertEquals(rachelAccount.getAnnualInterestRate(), .3, 1);
	}
	
	/**
	 * Test for getDateCreated
	 */
	@Test
	public void testGetDateCreated() {
		Date marchNinth = new Date();
		assertEquals(ryanAccount.getDateCreated(), marchNinth);
	}
	
	/**
	 * Test getMonthlyInterestRate
	 */
	@Test
	public void testGetMonthlyInterestRate() {
		assertEquals(rebeccaAccount.getMonthlyInterestRate(), rebeccaAccount.getAnnualInterestRate() * (1 / 12), 1);
		assertEquals(elizabethAccount.getMonthlyInterestRate(), elizabethAccount.getAnnualInterestRate() * (1 / 12), 1);
		assertEquals(rachelAccount.getMonthlyInterestRate(), rachelAccount.getAnnualInterestRate() * (1 / 12), 1);
	}
	
	// TESTS FOR SETTERS
	
	/**
	 * Test for setId
	 */
	@Test
	public void testSetId() {
		int number = 1;
		ryanAccount.setId(number);
		assertEquals(ryanAccount.getId(), 1);
	}
	
	/**
	 * Test for setBalance
	 */
	@Test
	public void testSetBalance() {
		double number = 1;
		ryanAccount.setBalance(number);
		assertEquals(ryanAccount.getBalance(), 1, 1);
	}
	
	/**
	 * Test for setAnnualInterestRate
	 */
	@Test
	public void testSetAnnualInterestRate() {
		double number = .0;
		ryanAccount.setAnnualInterestRate(number);
		assertEquals(ryanAccount.getAnnualInterestRate(), .0, 1);
	}
	
	// TESTS FOR OTHER METHODS
	
	// Note for self: Since Exception is a checked exception, you either:
	// have to catch the exception in a try...catch statement, or
	// declare the exception to be thrown in the method itself.
	
	// Side note: As of now, testWithdraw works, but ask about exceptions,
	// try, and catch for further explanation.
	
	/**
	 * Test for withdraw
	 */
	@Test
	public void testWithdraw() {
		double startBal0 = rebeccaAccount.getBalance();
		double withdrawAmount0 = 2500;
		try {
			rebeccaAccount.withdraw(withdrawAmount0);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		assertEquals(rebeccaAccount.getBalance(), startBal0 - withdrawAmount0, 0.01);
	}
	
	/**
	 * Test for deposit
	 * Prints information to the console as instructed.
	 */
	@Test
	public final void testDeposit() {
		double startBal0 = rebeccaAccount.getBalance();
		double depositAmount0 = 3000;
		rebeccaAccount.deposit(depositAmount0);
		assertEquals(rebeccaAccount.getBalance(), startBal0 + depositAmount0, 0.01);
		double startBal1 = rebeccaAccount.getBalance();
		double depositAmount1 = 10.00;
		rebeccaAccount.deposit(depositAmount1);
		assertEquals(rebeccaAccount.getBalance(), startBal1 + depositAmount1, 0.01);
		double startBal2 = rebeccaAccount.getBalance();
		double depositAmount2 = 10.00;
		rebeccaAccount.deposit(depositAmount2);
		assertEquals(rebeccaAccount.getBalance(), startBal2 + depositAmount2, 0.01);
		
		System.out.println("For account number 1122, the balance is $20,000, the monthly interest rate is 0.375% (from annual interest rate of 4.5%), and the account was created on March 9, 2016.");
	}		
}