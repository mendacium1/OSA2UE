package machine;

import java.util.logging.Logger;

import machine.state.GumballMachineState;
import machine.state.IdleState;

/**
 * Simple gumball machine.
 *
 * @author Claudia
 * @version 1.0
 */
public class GumballMachine {

	private static final Logger LOG = Logger.getLogger(GumballMachine.class.getName());

	int nrOfGumballs;
	GumballMachineState state;

	/**
	 * Create a new gumball machine filled with the given number of gumballs.
	 *
	 * @param nrOfGumballs
	 *            the intial amount of gumballs in the machine
	 */
	public GumballMachine(int nrOfGumballs) {
		this.nrOfGumballs = nrOfGumballs;
		this.state = new IdleState(this);
	}

	/**
	 * Insert a coin into the machine.
	 */
	public void insert() {
		LOG.info("A coin is inserted into the machine");
		state.insert();
	}

	/**
	 * Eject the coin, if available.
	 */
	public void eject() {
		LOG.info("Eject coin");
		state.eject();
	}

	/**
	 * Turn crank to dispense gumball.
	 */
	public void turn() {
		LOG.info("Turn crank");
		state.turn();
	}

	/**
	 * @return number of gumballs available
	 */
	public int getNrOfGumballs() {
		return nrOfGumballs;
	}

	/**
	 * Set the number of gumballs.
	 *
	 * @param nrOfGumballs
	 */
	public void setNrOfGumballs(int nrOfGumballs) {
		this.nrOfGumballs = nrOfGumballs;
	}

	/**
	 * @return the current state of the machine
	 */
	public GumballMachineState getState() {
		return state;
	}

	/**
	 * Set the state of the machine.
	 *
	 * @param state
	 */
	public void setState(GumballMachineState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "The machine is in " + state + " state. There are " + nrOfGumballs + " gumballs left in the machine.";
	}
}
