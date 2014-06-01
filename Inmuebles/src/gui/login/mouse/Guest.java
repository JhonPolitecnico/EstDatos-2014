package gui.login.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.login.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Load the selected list
 * 
 */
public class Guest extends MouseAdapter {

	private Controller loginController;

	public Guest(Controller loginController) {
		super();
		this.loginController = loginController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.loginController.setSession(new user.Guest());
		new gui.property.list.Controller(this.loginController);
		this.loginController.dispose();
	}
}
