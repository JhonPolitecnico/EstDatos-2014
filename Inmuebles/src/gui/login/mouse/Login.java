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

import javax.swing.JOptionPane;

import user.Rol;
import user.User;

/**
 * Load the selected list
 * 
 */
public class Login extends MouseAdapter {

	private Controller loginController;

	public Login(Controller loginController) {
		super();
		this.loginController = loginController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		String username = this.loginController.getTextUsername().getText();
		String password = this.loginController.getTextPwd().getText();

		for (Rol rol : this.loginController.getRoles()) {

			if (!(rol instanceof User))
				continue;

			User user = (User) rol;

			if (user.getNick().equals(username) && user.getPassword().equals(password)) {
				this.loginController.setSession(rol);
				break;
			}

		}

		if (this.loginController.getSession() == null) {
			JOptionPane.showMessageDialog(this.loginController, "Usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		/**
		 * Remove credentials
		 */
		this.loginController.getTextUsername().setText("");
		this.loginController.getTextPwd().setText("");

		/**
		 * Show main frame
		 */
		new gui.property.list.Controller(this.loginController);
		this.loginController.dispose();
	}
}
