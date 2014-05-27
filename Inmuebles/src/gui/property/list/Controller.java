package gui.property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import property.Property;
import property.list.PropertyCellRender;
import property.list.PropertyTableModel;
import user.mask.Flag;
import utils.Utils;

public class Controller extends List {

	private static final long serialVersionUID = 1762422748309620751L;

	private gui.login.Controller loginController;
	private PropertyTableModel propertyTable;

	public Controller(gui.login.Controller loginController) {
		super();
		this.loginController = loginController;

		/**
		 * Permissions
		 */
		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW))
			Utils.fatalExit();

		/**
		 * Model
		 */
		this.propertyTable = new PropertyTableModel();
		for (int i = 1; i <= 30; i++) {
			Property property = new Property(45.5, "Calle 98 No 34 - 21", "Bogota", 3, 454555, 5555, 44, "time", 7777, true, "desp...", "photo", 4, true, 6);
			this.propertyTable.addRow(property);
		}

		super.table.setModel(this.propertyTable);
		super.table.setDefaultRenderer(Object.class, new PropertyCellRender());

		super.setVisible(true);
	}

}
