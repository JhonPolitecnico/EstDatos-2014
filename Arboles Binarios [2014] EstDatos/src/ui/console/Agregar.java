package ui.console;

import java.util.Scanner;
import kernel.binary.tree.Arbol;
import kernel.console.Action;
import kernel.console.ConsoleUI;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Agregar extends Action {

	public Agregar(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "agregar";
	}

	@Override
	public void execute(Scanner scanner) {
		Arbol arbol = ((UI) this.UI).getArbol();

		System.out.println("Escribe el numero a agregar:");

		if (scanner.hasNextInt()) {
			boolean ret = arbol.addNode(scanner.nextInt());
			if (ret)
				System.out.println("Numero agregado!");
			else
				System.out.println("El numero no se pudo agregar :'c");
		} else {
			System.out.println("El numero es invalido");
			this.UI.skipError();
		}
	}

}
