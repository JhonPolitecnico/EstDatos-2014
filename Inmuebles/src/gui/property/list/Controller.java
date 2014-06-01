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
import gui.property.list.mouse.RegisterUser;
import gui.property.list.mouse.View;
import gui.property.list.mouse.ViewEstate;
import gui.property.list.window.WindowController;
import property.Property;
import property.list.PropertyTableGUI;
import property.list.PropertyTableModel;
import user.Admin;
import user.Owner;
import user.Rol;
import user.User;
import user.mask.Flag;
import utils.Utils;

public class Controller extends List implements PropertyTableGUI {

	private static final long serialVersionUID = 1762422748309620751L;

	private PropertyTableGUI owner;
	private gui.login.Controller loginController;
	private PropertyTableModel propertyTable;
	private boolean currentUser;

	/**
	 * Create a current user subframe from main frame
	 * 
	 * @param owner
	 * @param loginController
	 */
	public Controller(PropertyTableGUI owner, gui.login.Controller loginController) {
		super();
		this.prepare(owner, loginController, true);
	}

	/**
	 * Create main frame
	 * 
	 * @param loginController
	 */
	public Controller(gui.login.Controller loginController) {
		super();
		this.prepare(null, loginController, false);
	}

	/**
	 * Prepare frame to determine the behavior
	 * 
	 * @param owner
	 * @param loginController
	 * @param currentUser
	 */
	private void prepare(PropertyTableGUI owner, gui.login.Controller loginController, boolean currentUser) {
		this.loginController = loginController;
		this.currentUser = currentUser;
		this.owner = owner;

		Owner userOwner = null;
		boolean isAdmin = false;

		if (this.currentUser) {
			if (!(this.loginController.getSession() instanceof Owner))
				Utils.fatalExit();

			userOwner = (Owner) this.loginController.getSession();
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
		 * Permissions if is current user or admin
		 */
		super.mntmViewEstate.setVisible(!this.currentUser);
		super.mntmEdit.setVisible(this.currentUser | isAdmin);
		super.mntmDelete.setVisible(this.currentUser | isAdmin);
		super.mntmLogout.setVisible(!this.currentUser);
		super.mntmRegisterUser.setVisible(!this.currentUser & isAdmin & Flag.isFlag(this.loginController.getSession().getFlags(), Flag.ADMIN_REGISTER_USER));
		super.mntmRegisterUser.setEnabled(super.mntmRegisterUser.isVisible());

		/**
		 * Model
		 */
		this.propertyTable = new PropertyTableModel(super.table);

		if (this.currentUser)
			this.propertyTable.setProperties(userOwner.getProperties());
		else {
			for (Rol rol : this.loginController.getRoles())
				if (rol instanceof Owner)
					for (Property property : ((Owner) rol).getProperties())
						this.propertyTable.addRow(property);
		}

		super.table.setModel(this.propertyTable);

		/**
		 * Events
		 */
		super.addWindowListener(new WindowController(this.loginController));

		super.mntmViewEstate.addActionListener(new ViewEstate(this, this.loginController));
		super.mntmAddEstate.addActionListener(new AddEstate(this, this.loginController));
		super.mntmLogout.addActionListener(new Logout(this, this.loginController));
		super.mntmExit.addActionListener(new Exit(this));

		super.mntmView.addActionListener(new View(this, this.loginController));
		super.mntmEdit.addActionListener(new Edit(this, this.loginController));
		super.mntmDelete.addActionListener(new Delete(this));

		super.mntmRegisterUser.addActionListener(new RegisterUser(this.loginController));

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
		if (this.currentUser) {
			super.table.revalidate();
			super.table.repaint();
			this.owner.refreshProperies();
		} else {
			this.propertyTable.clear();

			for (Rol rol : this.loginController.getRoles())
				if (rol instanceof Owner)
					for (Property property : ((Owner) rol).getProperties())
						this.propertyTable.addRow(property);
		}
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
