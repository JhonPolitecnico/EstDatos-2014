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
public class Preorden extends Action {

	public Preorden(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "preorden";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Preorden: " + ((UI) this.UI).getArbol().preorden());
	}

}
