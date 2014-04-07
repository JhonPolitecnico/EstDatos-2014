package ui.console;

import java.util.Scanner;

import kernel.console.Action;
import kernel.console.ConsoleUI;

public class Inorden extends Action {

	public Inorden(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "inorden";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Inorden: " + ((UI) this.UI).getArbol().inorden());
	}

}
