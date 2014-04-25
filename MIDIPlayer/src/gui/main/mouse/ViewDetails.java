package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import midi.Cancion;

public class ViewDetails implements ActionListener {

	private Controller controller;

	public ViewDetails(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {

		if (controller.getOwner().getList().isSelectionEmpty())
			return;

		new gui.details.Controller(this.controller.getOwner(), (Cancion) controller.getOwner().getList().getSelectedValue());
	}

}
