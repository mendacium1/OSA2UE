package machine.state;

import machine.GumballMachine;

/**
 * Represents the empty state of the gumball machine.
 * <p>
 * Has coin means that
 * <li>no gumballs are available
 * 
 * @author Claudia
 * @version 1.0
 */
public class EmptyState extends AbstractGumballMachineState {

	public EmptyState(GumballMachine machine) {
		super(machine);
	}

	/**
	 * Does not accept coin since there are no gumballs to dispense.
	 * 
	 * @see machine.state.GumballMachineState#insert()
	 */
	@Override
	public void insert() {
		System.out.println("I cannot accept coin. The machine is out of gumballs!");
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
	 * Does nothing as there is no gumball available.
	 * 
	 * @see machine.state.GumballMachineState#turn()
	 */
	@Override
	public void turn() {
		System.out.println("The machine is out of gumballs!");
	}

	@Override
	public String toString() {
		return "EMPTY";
	}
}
