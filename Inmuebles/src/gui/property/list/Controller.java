package gui.property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.property.list.mouse.Exit;
import gui.property.list.mouse.Logout;
import gui.property.list.mouse.AddEstate;
import gui.property.list.mouse.ViewEstate;
import property.Property;
import property.list.PropertyTableModel;
import user.Admin;
import user.User;
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
		super.menuBar.setVisible(!(this.loginController.getSession().getFlags() == Flag.VIEW));

		super.mnAdmin.setVisible(this.loginController.getSession() instanceof Admin);

		super.mntmViewProfile.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROFILE_VIEW));
		super.mntmEditProfile.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROFILE_EDIT));

		super.mntmViewEstate.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_VIEW));
		super.mntmAddEstate.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_NEW));

		super.mntmLogout.setEnabled(this.loginController.getSession() instanceof User);

		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW))
			Utils.fatalExit();

		/**
		 * Model
		 */
		this.propertyTable = new PropertyTableModel(super.table);
		for (int i = 1; i <= 30; i++) {
			Property property = new Property(45.5, "Calle 98 No 34 - 21", "Bogota", 3, 454555, 5555, 44, "time", 7777, true, "desp...", "house.jpg");
			this.propertyTable.addRow(property);
		}

		super.table.setModel(this.propertyTable);

		/**
		 * Events
		 */
		super.mntmViewEstate.addActionListener(new ViewEstate(this, this.loginController));
		super.mntmAddEstate.addActionListener(new AddEstate(this, this.loginController));
		super.mntmLogout.addActionListener(new Logout(this, this.loginController));
		super.mntmExit.addActionListener(new Exit());

		/**
		 * GUI
		 */
		Utils.centerFrame(this);
		super.setVisible(true);
	}

}
