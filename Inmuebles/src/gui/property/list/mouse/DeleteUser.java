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
public class DeleteUser implements ActionListener {

	private Controller loginController;

	public DeleteUser(Controller loginController) {
		super();
		this.loginController = loginController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new gui.user.manager.Controller(this.loginController);
	}
}
