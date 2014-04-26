package gui.details.mouse;

import gui.details.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancel implements ActionListener {

	private Controller controller;

	public Cancel(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		this.controller.dispose();
	}

}
