package kernel.console;

import java.util.Scanner;

public abstract class Action {

	protected ConsoleUI UI;

	public abstract String name();

	public abstract void execute(Scanner scanner);

	public Action(ConsoleUI UI) {
		this.UI = UI;
	}
}
