package ui.console;

import kernel.console.Action;
import kernel.console.ConsoleUI;

public class UI extends ConsoleUI {

	@Override
	protected Action[] registerCommands() {
		return new Action[] { new Hello(this), new Login(this), new Exit(this) };
	}

	@Override
	protected void printHeader() {
		System.out.println("Esto es el header");
	}

	@Override
	protected void printMenu() {
		System.out.println();
		System.out.println("hello world:\tHola Mundo");
		System.out.println("login:\t\tIdentificarse");
		System.out.println("exit:\t\tSalir");
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

	@Override
	protected void onInvalidCommand(String command) {
		System.out.println("No selecciono una opci\u00F3n valida");
	}

}
