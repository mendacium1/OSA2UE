package machine.state;

/**
 * Inteface for gumball machine states.
 * <p>
 * Defines the basic interaction possiblities.
 * 
 * @author Claudia
 * @version 1.0
 */
public interface GumballMachineState {

	/**
	 * Insert a coin into the machine.
	 */
	void insert();

	/**
	 * Eject the coin.
	 */
	void eject();

	/**
	 * Dispense a gumball.
	 */
	void turn();

}
