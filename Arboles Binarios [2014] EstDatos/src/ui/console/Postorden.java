package ui.console;

import java.util.Scanner;

import kernel.console.Action;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Postorden extends Action {

	public Postorden(UI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "postorden";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Postorden: " + ((UI) this.UI).getArbol().postorden());
	}

}
