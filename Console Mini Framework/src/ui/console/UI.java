package ui.console;

import kernel.console.ConsoleUI;

public class UI extends ConsoleUI {

	@Override
	protected String[] registerCommands() {
		String[] commands = { "hello", "exit" };
		return commands;
	}

	@Override
	protected void printHeader() {
		System.out.println("Esto es el header");
	}

	@Override
	protected void printMenu() {
		System.out.println();
		System.out.println("hello:\tHola Mundo");
		System.out.println("exit:\tSalir");
		System.out.println();

	}

	@Override
	protected void onError(Exception e) {
		System.out.println("\nOpps, ocurrio un error :!");
		System.out.println("Error: " + e.getMessage());
		System.out.println("Bye!");

	}

	@Override
	protected void onCommand(String command) {
		// ...
	}

	public void helloAction() {
		System.out.println("Hola Mundo!");
	}

	public void exitAction() {
		System.out.println("Bye!");
		this.off();
	}

}
