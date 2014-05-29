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

import property.list.PropertyTableGUI;

/**
 * Exit application
 * 
 */
public class Exit implements ActionListener {

	private PropertyTableGUI owner;
	private Controller editController;

	public Exit(PropertyTableGUI owner, Controller editController) {
		super();
		this.owner = owner;
		this.editController = editController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		this.owner.refreshProperies();
		this.editController.dispose();
	}
}
