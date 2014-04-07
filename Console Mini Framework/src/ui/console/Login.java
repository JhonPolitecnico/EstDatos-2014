package ui.console;

import java.util.Scanner;
import kernel.console.Action;
import kernel.console.ConsoleUI;

public class Login extends Action {

	public Login(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "login";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Escribe tu nombre:");
		if (scanner.hasNext())
			System.out.println("Tu nombre es: " + scanner.next());

		System.out.println("Escribe tu ID:");
		if (scanner.hasNextInt())
			System.out.println("Tu ID es: " + scanner.nextInt());
		else {
			System.out.println("Tu ID es invalido");
			this.UI.skipError();
		}
	}

}
