package ui.console;

import kernel.console.ConsoleUI;

public class UI extends ConsoleUI {

	@Override
	protected String[] registerCommands() {
		return new String[] { "hello world:hello", "login", "exit" };
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

	/*
	 * Actions
	 */

	public void helloAction() {
		System.out.println("Hola Mundo!");
	}

	public void loginAction() {
		System.out.println("Escribe tu nombre:");
		if (this.in.hasNext())
			System.out.println("Tu nombre es: " + this.in.next());

		System.out.println("Escribe tu ID:");
		if (this.in.hasNextInt())
			System.out.println("Tu ID es: " + this.in.nextInt());
		else {
			System.out.println("Tu ID es invalido");
			this.skipError();
		}

	}

	public void exitAction() {
		System.out.println("Bye!");
		this.off();
	}

}
