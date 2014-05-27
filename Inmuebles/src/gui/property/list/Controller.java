package gui.property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.mask.Flag;
import utils.Utils;

public class Controller extends List {

	private static final long serialVersionUID = 1762422748309620751L;

	private gui.login.Controller loginController;

	public Controller(gui.login.Controller loginController) {
		super();
		this.loginController = loginController;

		/**
		 * Permissions
		 */
		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW))
			Utils.fatalExit();

		super.setVisible(true);
	}

}
