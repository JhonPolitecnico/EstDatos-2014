package gui.user.manager.mouse;

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
import utils.Utils;

/**
 * Load the selected list
 * 
 */
public class Delete extends MouseAdapter {

	private gui.user.manager.Controller managerController;
	private Controller loginController;

	public Delete(gui.user.manager.Controller managerController, Controller loginController) {
		super();
		this.managerController = managerController;
		this.loginController = loginController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int index = this.managerController.getList().getSelectedIndex();

		if (index < 0)
			return;

		for (Rol rol : this.loginController.getRoles())
			if (rol.toString().equals(this.managerController.getList().getModel().getElementAt(index))) {
				this.loginController.removeRol(rol);
				break;
			}

		if (this.loginController.getSession() == null)
			Utils.fatalExit();

		JOptionPane.showMessageDialog(this.loginController, "Usuario eliminado con exito", "OK", JOptionPane.INFORMATION_MESSAGE);

		this.managerController.dispose();
	}
}
