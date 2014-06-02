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
 * Load the "Details" frame
 * 
 */
public class ViewDetails implements ActionListener {

	private Controller controller;

	public ViewDetails(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {

		int rows[] = this.controller.getTable().getSelectedRows();

		for (int row : rows)
			new gui.details.Controller(this.controller, this.controller.getTable().convertRowIndexToModel(row));
	}

}
