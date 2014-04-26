package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyList implements ActionListener {

	private Controller controller;

	public EmptyList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		controller.getMIDIList().clear();
	}

}
