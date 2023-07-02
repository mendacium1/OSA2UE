
import java.math.BigDecimal;

/**
 * The class <code>Account</code> represents a financial account between a bank
 * customer and a financial institution.
 * 
 * @author Claudia
 * 
 */
public class Account {
	private static int nextAccountNumber = 1000;
	private static int nrOfAccounts = 0;

	/**
	 * @return the total number of accounts which have been created
	 */
	public static int getNrOfAccounts() {
		return nrOfAccounts;
	}

	private final String accountNumber;
	private BigDecimal balance;

	/**
	 * Creates a new <code>Account</code> object with an initial balance of 0.
	 */
	public Account() {
		this(new BigDecimal(0));
	}

	/**
	 * Creates a new <code>Account</code> object with an initial balance of the
	 * given amount.
	 * 
	 * @param amount
	 *            the initial balance of the account
	 */
	public Account(BigDecimal amount) {
		accountNumber = String.format("52%08d", nextAccountNumber++);
		balance = amount;
		nrOfAccounts++;
	}

	/**
	 * @return the account number of the account
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the current balance of the account
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Deposit an amount to the current account. The amount is deducted from the
	 * given account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @param from
	 *            the account the amount is deducted from
	 */
	public void deposit(BigDecimal amount, Account from) {
		balance = balance.add(amount);
		from.disburse(amount);
	}

	private void disburse(BigDecimal amount) {
		balance = balance.subtract(amount);
	}

	/**
	 * Disburse an amount from the current account. The amount is added to the
	 * given account.
	 * 
	 * @param amount
	 *            the amount to disburse
	 * @param to
	 *            the account the amount is added to
	 */
	public void disburse(BigDecimal amount, Account to) {
		balance = balance.subtract(amount);
		to.deposit(amount);
	}

	private void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
}
