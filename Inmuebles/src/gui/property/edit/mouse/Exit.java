package gui.property.edit.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.property.edit.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exit application
 * 
 */
public class Exit implements ActionListener {

	private Controller editController;

	public Exit(Controller editController) {
		super();
		this.editController = editController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		this.editController.dispose();
	}
}
