package gui.register;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.register.mouse.Exit;
import gui.register.mouse.Save;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import user.Admin;
import user.mask.Flag;
import utils.Utils;

public class Controller extends Register {

	private static final long serialVersionUID = -7890126190791099959L;

	private gui.login.Controller loginController;

	public Controller(gui.login.Controller loginController) {
		super();
		this.loginController = loginController;

		/**
		 * Permissions
		 */
		if (!(this.loginController.getSession() instanceof Admin))
			Utils.fatalExit();

		Admin admin = (Admin) this.loginController.getSession();

		if (!Flag.isFlag(admin.getFlags(), Flag.ADMIN_REGISTER_USER))
			Utils.fatalExit();

		/**
		 * Events
		 */
		super.btnCancel.addMouseListener(new Exit(this));
		super.btnRegister.addMouseListener(new Save(this, this.loginController));

		/**
		 * GUI
		 */
		super.setTitle("Registrar usuario" + Utils.getTitle());
		Utils.centerFrame(this);
		this.setVisible(true);
	}

	public JTextField getTxtUsername() {
		return super.txtUsername;
	}

	public JTextField getTxtPassword() {
		return super.txtPassword;
	}

	public JComboBox<String> getCmbUserType() {
		return super.cmbUserType;
	}
}
