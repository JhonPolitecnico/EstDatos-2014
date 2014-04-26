package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteElement implements ActionListener {

	private Controller controller;

	public DeleteElement(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {

		if (controller.getList().isSelectionEmpty())
			return;

		for (Object element : controller.getList().getSelectedValuesList())
			controller.getMIDIList().removeElement(element);

	}

}
