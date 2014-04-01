package kernel.console;

import java.util.Scanner;

public abstract class ConsoleUI {

	protected Scanner in;
	protected String command = "";
	protected boolean off = false;
	protected String[] commands;

	protected abstract String[] registerCommands();

	protected abstract void printHeader();

	protected abstract void printMenu();

	protected abstract void onError(Exception e);

	protected abstract void onCommand(String command);

	protected abstract void onInvalidCommand(String command);

	protected ConsoleUI() {
		this.commands = this.registerCommands();
	}

	/**
	 * Avoid an infinite loop when an invalid expression is entered
	 */
	protected void skipError() {
		in.next();
	}

	protected void invokeAction(String action) {
		try {
			this.getClass().getMethod(action + "Action").invoke(this);
		} catch (Exception e) {
			this.onError(e);
		}
	}

	protected void off() {
		this.off = true;
	}

	public void on() {
		try {

			in = new Scanner(System.in).useDelimiter(System.lineSeparator());

			try {
				this.printHeader();

				do {
					Engine: {
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

						// Return action
						this.onCommand(command);

						// Run Command
						for (int i = 0; i < commands.length; i++) {

							if (command.equals(commands[i])) {
								this.invokeAction(command);
								break Engine;

							} else if ((commands[i].split(":").length == 2) && (command.equals(commands[i].split(":")[0]))) {
								this.invokeAction(commands[i].split(":")[1]);
								break Engine;
							}

						}

						// No valid command
						this.onInvalidCommand(command);
					}
				} while (true);

			} catch (Exception e) {
				this.onError(e);
			}
		} finally {
			in.close();
		}

	}
}