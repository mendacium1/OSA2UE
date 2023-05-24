package machine.state;

import machine.GumballMachine;

/**
 * Represents the idle state of the gumball machine.
 * <p>
 * Idle means that
 * <li>gumballs are available
 * <li>but no coin was inserted
 * 
 * @author Claudia
 * @version 1.0
 */
public class IdleState extends AbstractGumballMachineState {

	public IdleState(GumballMachine machine) {
		super(machine);
	}

	/*
	 * (non-Javadoc)
	 * @see machine.state.GumballMachineState#insert()
	 */
	@Override
	public void insert() {
		System.out.println("Coin is inserted.");
		machine.setState(new HasCoinState(machine));
	}

	/**
	 * Does nothing as there is no coin available.
	 * 
	 * @see machine.state.GumballMachineState#eject()
	 */
	@Override
	public void eject() {
		System.out.println("There is no coin.");
	}

	/**
	 * Does nothing as there is no coin available.
	 * 
	 * @see machine.state.GumballMachineState#turn()
	 */
	@Override
	public void turn() {
		System.out.println("Please insert coin first.");
	}

	@Override
	public String toString() {
		return "IDLE";
	}
}
