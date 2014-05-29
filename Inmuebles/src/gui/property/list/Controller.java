package gui.property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JTable;

import gui.property.list.mouse.Delete;
import gui.property.list.mouse.Edit;
import gui.property.list.mouse.Exit;
import gui.property.list.mouse.Logout;
import gui.property.list.mouse.AddEstate;
import gui.property.list.mouse.View;
import gui.property.list.mouse.ViewEstate;
import property.Property;
import property.list.PropertyTableGUI;
import property.list.PropertyTableModel;
import user.Admin;
import user.Owner;
import user.User;
import user.mask.Flag;
import utils.Utils;

public class Controller extends List implements PropertyTableGUI {

	private static final long serialVersionUID = 1762422748309620751L;

	private gui.login.Controller loginController;
	private PropertyTableModel propertyTable;
	private boolean currentUser;

	public Controller(gui.login.Controller loginController, boolean currentUser) {
		super();
		this.loginController = loginController;
		this.currentUser = currentUser;

		Owner owner = null;
		boolean isAdmin = false;

		if (this.currentUser) {
			if (!(this.loginController.getSession() instanceof Owner))
				Utils.fatalExit();

			owner = (Owner) this.loginController.getSession();
		} else
			isAdmin = this.loginController.getSession() instanceof Admin;

		/**
		 * Permissions
		 */
		if (!Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW))
			Utils.fatalExit();

		// If is guest
		super.menuBar.setVisible(!(this.loginController.getSession().getFlags() == Flag.VIEW));

		super.mnAdmin.setVisible(this.loginController.getSession() instanceof Admin);

		super.mntmViewProfile.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROFILE_VIEW));
		super.mntmEditProfile.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROFILE_EDIT));

		super.mntmViewEstate.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_VIEW));
		super.mntmAddEstate.setEnabled(Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_NEW));

		super.mntmLogout.setEnabled(this.loginController.getSession() instanceof User);

		/**
		 * Permissions if is current user
		 */
		super.mntmViewEstate.setVisible(!this.currentUser);
		super.mntmEdit.setVisible(this.currentUser | isAdmin);
		super.mntmDelete.setVisible(this.currentUser | isAdmin);
		super.mntmLogout.setVisible(!this.currentUser);

		/**
		 * Model
		 */
		this.propertyTable = new PropertyTableModel(super.table);

		if (this.currentUser)
			this.propertyTable.setProperties(owner.getProperties());
		else {

			for (int i = 1; i <= 30; i++) {
				Property property = new Property(45.5, "Calle 98 No 34 - 21", "Bogota", 3, 454555, 5555, 44, "7 años", 7777, true, "desp...", "house.jpg");
				this.propertyTable.addRow(property);
			}
		}

		super.table.setModel(this.propertyTable);

		/**
		 * Events
		 */
		super.mntmViewEstate.addActionListener(new ViewEstate(this, this.loginController));
		super.mntmAddEstate.addActionListener(new AddEstate(this, this.loginController));
		super.mntmLogout.addActionListener(new Logout(this, this.loginController));
		super.mntmExit.addActionListener(new Exit(this));

		super.mntmView.addActionListener(new View(this, this.loginController));
		super.mntmEdit.addActionListener(new Edit(this, this.loginController));
		super.mntmDelete.addActionListener(new Delete(this));

		/**
		 * GUI
		 */
		if (!this.currentUser) {
			super.setDefaultCloseOperation(EXIT_ON_CLOSE);
			super.setTitle("Inmuebles" + Utils.getTitle());
		} else {
			super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			super.setTitle("Mis Inmuebles" + Utils.getTitle());
		}
		Utils.centerFrame(this);
		super.setVisible(true);
	}

	@Override
	public void refreshProperies() {
		super.table.revalidate();
		super.table.repaint();
	}

	public JTable getTable() {
		return super.table;
	}

	public PropertyTableModel getPropertyTable() {
		return propertyTable;
	}

	public boolean isCurrentUser() {
		return this.currentUser;
	}

}
