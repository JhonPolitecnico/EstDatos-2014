package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadList implements ActionListener {

	private Controller controller;

	public LoadList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		new gui.load.Controller(this.controller);
	}

}
