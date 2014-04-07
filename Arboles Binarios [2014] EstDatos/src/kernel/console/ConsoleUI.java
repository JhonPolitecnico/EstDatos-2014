package kernel.console;

import java.util.Scanner;

public abstract class ConsoleUI {

	protected Scanner in;
	protected String command = "";
	protected boolean off = false;
	protected Action[] actions;

	/**
	 * Register commands to use
	 * 
	 * @return
	 */
	protected abstract Action[] registerCommands();

	/**
	 * Print header
	 */
	protected abstract void printHeader();

	/**
	 * Print menu
	 */
	protected abstract void printMenu();

	/**
	 * On error
	 * 
	 * @param e
	 */
	protected abstract void onError(Exception e);

	/**
	 * On receipt of a valid or invalid command
	 * 
	 * @param command
	 */
	protected abstract void onCommand(String command);

	/**
	 * When receiving an invalid command
	 * 
	 * @param command
	 */
	protected abstract void onInvalidCommand(String command);

	protected ConsoleUI() {
		this.actions = this.registerCommands();
	}

	/**
	 * Avoid an infinite loop when an invalid expression is entered
	 */
	public void skipError() {
		in.next();
	}

	/**
	 * Invoke an action
	 * 
	 * @param action
	 */
	protected void execute(String action) {
		for (int i = 0; i < actions.length; i++) {
			if (action.equals(actions[i].name())) {
				actions[i].execute(this.in);
				return;
			}
		}
		this.onInvalidCommand(action);
	}

	/**
	 * Turn off console
	 */
	public void off() {
		this.off = true;
	}

	/**
	 * Turn console
	 */
	public void on() {
		try {

			in = new Scanner(System.in).useDelimiter(System.lineSeparator());

			try {
				this.printHeader();

				do {

					if (this.off)
						break;

					this.printMenu();

					do {
						// Get action
						if (in.hasNext())
							command = in.next();
						else {
							command = "";
						}

						// avoid commands empty
						if (!command.equals("")) {
							break;
						}
					} while (true);

					// New line
					System.out.println();

					// Return command
					this.onCommand(command);

					// Run Command
					this.execute(command);

				} while (true);

			} catch (Exception e) {
				this.onError(e);
			}
		} finally {
			in.close();
		}

	}
}