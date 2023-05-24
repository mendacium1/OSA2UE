package machine;

public class GumballMachineTest {

	/**
	 * Simple test for {@link GumballMachine}.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(3);

		System.out.println(machine + "\n");
		machine.eject();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.turn();
		System.out.println(machine + "\n");
		machine.turn();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.eject();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.turn();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.turn();
		System.out.println(machine + "\n");
		machine.insert();
		System.out.println(machine + "\n");
		machine.turn();
		System.out.println(machine + "\n");
	}

}
