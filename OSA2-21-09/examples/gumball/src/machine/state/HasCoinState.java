package machine.state;

import machine.GumballMachine;

/**
 * Represents the has coin state of the gumball machine.
 * <p>
 * Has coin means that
 * <li>gumballs are available
 * <li>an a coin was inserted
 * 
 * @author Claudia
 * @version 1.0
 */
public class HasCoinState extends AbstractGumballMachineState {

	public HasCoinState(GumballMachine machine) {
		super(machine);
	}

	/**
	 * Does not accept coin as there is already a coin.
	 * 
	 * @see machine.state.GumballMachineState#insert()
	 */
	@Override
	public void insert() {
		System.out.println("You have already inserted a coin.");
	}

	@Override
	public void eject() {
		System.out.println("Coin ejected.");
		machine.setState(new IdleState(machine));
	}

	@Override
	public void turn() {
		System.out.println("Dispense gumball.");
		machine.setNrOfGumballs(machine.getNrOfGumballs() - 1);
		if (machine.getNrOfGumballs() > 0) {
			machine.setState(new IdleState(machine));
		} else {
			machine.setState(new EmptyState(machine));
		}
	}

	@Override
	public String toString() {
		return "HAS_COIN";
	}
}
