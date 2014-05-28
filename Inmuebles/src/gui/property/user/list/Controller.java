package gui.property.user.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import property.list.PropertyTableModel;
import user.Owner;
import user.mask.Flag;
import utils.Utils;

public class Controller extends List {

	private static final long serialVersionUID = -1596371299139335322L;

	private gui.login.Controller loginController;
	private PropertyTableModel propertyTable;

	public Controller(gui.login.Controller loginController) {
		super();
		this.loginController = loginController;

		/**
		 * Permissions
		 */

		if (!(loginController.getSession() instanceof Owner))
			Utils.fatalExit();

		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_VIEW))
			Utils.fatalExit();

		Owner owner = (Owner) loginController.getSession();

		/**
		 * Model
		 */
		this.propertyTable = new PropertyTableModel(super.table);
		this.propertyTable.setProperties(owner.getProperties());
		super.table.setModel(this.propertyTable);

		/**
		 * Events
		 */

		/**
		 * GUI
		 */
		Utils.centerFrame(this);
		super.setVisible(true);
	}

}
