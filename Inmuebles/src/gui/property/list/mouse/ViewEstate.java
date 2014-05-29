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
public class ViewEstate implements ActionListener {

	private gui.property.list.Controller listController;
	private Controller loginController;

	public ViewEstate(gui.property.list.Controller listController, Controller loginController) {
		super();
		this.listController = listController;
		this.loginController = loginController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		new gui.property.list.Controller(this.loginController, true);
	}
}
