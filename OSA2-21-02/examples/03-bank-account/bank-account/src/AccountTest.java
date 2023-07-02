import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	Account accountA;
	Account accountB;
	Account accountC;

	@BeforeEach
	public void setUp() throws Exception {
		accountA = new Account();
		System.out.println("Konto " + accountA.getAccountNumber() + " angelegt.");
		accountB = new Account(new BigDecimal(1000));
		System.out.println("Konto " + accountB.getAccountNumber() + " angelegt.");
		accountC = new Account(new BigDecimal(10));
		System.out.println("Konto " + accountC.getAccountNumber() + " angelegt.");

		System.out.println("Gesamt wurden bis jetzt " + Account.getNrOfAccounts() + " Konten angelegt.");
	}

	@Test
	public void testDeposit() {
		accountA.deposit(new BigDecimal(500), accountB);

		assertEquals(new BigDecimal(500), accountA.getBalance());
		assertEquals(new BigDecimal(500), accountB.getBalance());

		accountC.deposit(new BigDecimal(700), accountB);

		assertEquals(new BigDecimal(710), accountC.getBalance());
		assertEquals(new BigDecimal(-200), accountB.getBalance());
	}

	@Test
	public void testDisburse() {
		accountA.disburse(new BigDecimal(500), accountB);

		assertEquals(new BigDecimal(-500), accountA.getBalance());
		assertEquals(new BigDecimal(1500), accountB.getBalance());

		accountC.disburse(new BigDecimal(-700), accountB);

		assertEquals(new BigDecimal(710), accountC.getBalance());
		assertEquals(new BigDecimal(800), accountB.getBalance());
	}

}
