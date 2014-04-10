package ui.console;

import java.util.Scanner;
import kernel.console.Action;
import kernel.console.ConsoleUI;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
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
			kernel.binary.tree.Nodo node = ((UI) this.UI).getArbol().search(scanner.nextInt());
			if (node == null)
				System.out.println("Numero encontrado!");
			else
				System.out.println("El numero no existe :'c");
		} else {
			System.out.println("El numero es invalido");
			this.UI.skipError();
		}
	}

}
