package beans;

import java.math.BigDecimal;

public class Account {
	private static int nextAccountNumber = 1000;

	private final String accountNumber;
	private BigDecimal balance;

	public Account() {
		this(new BigDecimal(0));
	}

	public Account(BigDecimal amount) {
		accountNumber = String.format("52%08d", nextAccountNumber++);
		balance = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void deposit(BigDecimal amount, Account from) {
		balance = balance.add(amount);
		from.disburse(amount);
	}

	private void disburse(BigDecimal amount) {
		balance = balance.subtract(amount);
	}

	public void disburse(BigDecimal amount, Account to) {
		balance = balance.subtract(amount);
		to.deposit(amount);
	}

	private void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}
}
