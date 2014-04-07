package ui.console;

import java.util.Scanner;

import kernel.console.Action;
import kernel.console.ConsoleUI;

public class Hoja extends Action {

	public Hoja(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "hojas";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("El numero de hojas del arbol es: " + ((UI) this.UI).getArbol().getNumberOfLeaves());
	}

}
