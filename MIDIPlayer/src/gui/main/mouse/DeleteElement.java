package gui.main.mouse;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Remove multiple songs selected
 *
 */
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
