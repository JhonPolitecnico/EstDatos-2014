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

		int rows[] = controller.getTable().getSelectedRows();

		for (int i = 0; i < rows.length; i++) {
			controller.getMIDITable().removeRow(this.controller.getTable().convertRowIndexToModel(rows[i] - i));
		}
	}
}
