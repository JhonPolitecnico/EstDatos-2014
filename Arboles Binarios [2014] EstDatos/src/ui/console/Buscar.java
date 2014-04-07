package ui.console;

import java.util.Scanner;
import kernel.console.Action;
import kernel.console.ConsoleUI;

public class Buscar extends Action {

	public Buscar(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "buscar";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Escribe el numero a buscar:");

		if (scanner.hasNextInt()) {
			boolean ret = ((UI) this.UI).getArbol().search(scanner.nextInt());
			if (ret)
				System.out.println("Numero encontrado!");
			else
				System.out.println("El numero no existe :'c");
		} else {
			System.out.println("El numero es invalido");
			this.UI.skipError();
		}
	}

}
