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
public class New extends MouseAdapter {

	private Controller loginController;

	public New(Controller loginController) {
		super();
		this.loginController = loginController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/**
		 * Show register frame
		 */
		new gui.register.Controller(this.loginController);
	}
}
