package machine.state;

import machine.GumballMachine;

abstract class AbstractGumballMachineState implements GumballMachineState {

	protected GumballMachine machine;

	public AbstractGumballMachineState(GumballMachine machine) {
		this.machine = machine;
	}

}
