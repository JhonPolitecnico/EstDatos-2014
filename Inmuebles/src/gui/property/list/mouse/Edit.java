package gui.property.list.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.login.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Load the selected list
 * 
 */
public class Edit implements ActionListener {

	private gui.property.list.Controller listController;
	private Controller loginController;

	public Edit(gui.property.list.Controller listController, Controller loginController) {
		super();
		this.listController = listController;
		this.loginController = loginController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		int rows[] = listController.getTable().getSelectedRows();

		for (int row : rows)
			new gui.property.edit.Controller(loginController, listController.getPropertyTable().getRow(row));
	}
}
