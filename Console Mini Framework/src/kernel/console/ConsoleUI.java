package kernel.console;

import java.util.Scanner;

public abstract class ConsoleUI {

	protected Scanner in;
	protected String command = "";
	protected boolean off = false;
	protected ConsoleUI self = null;
	protected String[] commands;

	protected abstract String[] registerCommands();

	protected abstract void printHeader();

	protected abstract void printMenu();

	protected abstract void onError(Exception e);

	protected abstract void onCommand(String command);

	protected ConsoleUI() {
		this.commands = this.registerCommands();
	}

	/**
	 * Avoid an infinite loop when an invalid expression is entered
	 */
	protected void skipError() {
		in.next();
	}

	protected void off() {
		this.off = true;
	}

	public void on() {
		try {

			in = new Scanner(System.in);

			try {
				this.printHeader();

				do {
					if (this.off)
						break;

					this.printMenu();

					// Get action
					if (in.hasNext())
						command = in.next();
					else {
						command = "";
						this.skipError();
					}

					// New line
					System.out.println();

					// Return action
					onCommand(command);

					// Run Command
					for (int i = 0; i < commands.length; i++) {
						if (command.equals(commands[i])) {
							try {
								this.getClass().getMethod(command + "Action").invoke(this);
							} catch (Exception e) {
								this.onError(e);
							}
							break;
						}

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