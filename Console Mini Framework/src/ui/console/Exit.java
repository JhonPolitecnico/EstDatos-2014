package ui.console;

import java.util.Scanner;

import kernel.console.Action;

public class Exit extends Action {

	public Exit(UI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "exit";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("Bye!");
		this.UI.off();
	}

}
