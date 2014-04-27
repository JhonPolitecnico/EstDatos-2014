package gui.load.check;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.save.Controller;

public class New implements ActionListener {

	private Controller controller;

	public New(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		this.controller.setNew(!controller.isNew());
	}

}
