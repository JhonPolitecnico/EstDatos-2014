package ui.console;

import java.util.Scanner;

import kernel.console.Action;
import kernel.console.ConsoleUI;

public class Hello extends Action {

	public Hello(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "hello world";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Hola Mundo!");
	}

}
