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
public class Salir extends Action {

	public Salir(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "salir";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Bye!");
		this.UI.off();
	}

}
