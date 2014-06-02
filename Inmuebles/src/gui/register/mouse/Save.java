package gui.register.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import user.Admin;
import user.Owner;
import user.Rol;
import user.User;
import user.mask.Flag;
import utils.Utils;

/**
 * Exit application
 * 
 */
public class Save extends MouseAdapter {

	private gui.register.Controller registerController;
	private gui.login.Controller loginController;

	public Save(gui.register.Controller registerController, gui.login.Controller loginController) {
		super();
		this.registerController = registerController;
		this.loginController = loginController;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		String username = this.registerController.getTxtUsername().getText();
		String password = this.registerController.getTxtPassword().getText();

		if (username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this.loginController, "Debe completar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		for (Rol rol : this.loginController.getRoles()) {

			if (!(rol instanceof User))
				continue;

			User user = (User) rol;

			if (user.getNick().equals(username)) {
				JOptionPane.showMessageDialog(this.loginController, "El nombre de usuario ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		int userType = this.registerController.getCmbUserType().getSelectedIndex();

		Rol newRol = null;

		/**
		 * User types:
		 * 
		 * 0 - Administrator
		 * 
		 * 1 - Owner
		 * 
		 * 2 - Client
		 */
		switch (userType) {
		case 0:
			/**
			 * Permissions
			 */
			if (this.loginController.getSession() == null || !Flag.isFlag(this.loginController.getSession().getFlags(), Flag.ADMIN_REGISTER_USER))
				Utils.fatalExit();

			newRol = new Admin("", "", 0, 0, 0, username, password, "");
			break;
		case 1:
			newRol = new Owner("", "", 0, 0, 0, username, password, "");
			break;
		default:
			return;
		}

		this.loginController.addRol(newRol);

		JOptionPane.showMessageDialog(this.loginController, "Usuario registrado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
		this.registerController.dispose();

	}
}
