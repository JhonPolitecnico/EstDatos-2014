package gui.login;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.login.mouse.Exit;
import gui.login.mouse.Guest;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import library.Library;
import serializer.engine.Serializer;
import user.Admin;
import user.Owner;
import user.Rol;
import utils.Utils;

public class Controller extends Login {

	private static final long serialVersionUID = -2376869953031761690L;

	private Rol session;
	private ArrayList<Rol> roles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Controller() {
		super();

		/**
		 * Serializer
		 */
		Serializer s = new Serializer(Utils.getLibrary());
		Object object = s.unserialize();

		if (object != null && object instanceof Library) {
			Library library = (Library) object;
			this.roles = library.getRoles();
		} else {
			this.roles = new ArrayList<Rol>();
			Admin admin = new Admin("Admin", "Admin", 6578904, 1140000000, 34533534, "admin", "admin", "admin@admin.com");
			this.roles.add(admin);
			Owner owner = new Owner("Owner", "Owner", 6578904, 1140000000, 34533534, "owner", "owner", "owner@owner.com");
			this.roles.add(owner);
		}

		/**
		 * Events
		 */
		super.btnExit.addMouseListener(new Exit());
		super.btnGuest.addMouseListener(new Guest(this));
		super.btnLogin.addMouseListener(new gui.login.mouse.Login(this));

		/**
		 * GUI
		 */
		super.setTitle(Utils.getTitleWithoutLine());
		try {
			super.lblLogo.setIcon(Utils.getImage("logo.png"));
		} catch (Exception e) {
			super.lblLogo.setIcon(null);
		}
		Utils.centerFrame(this);
	}

	public Rol getSession() {
		return session;
	}

	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setSession(Rol session) {
		this.session = session;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

	public JTextField getTextUsername() {
		return textUsername;
	}

	public JTextField getTextPwd() {
		return textPwd;
	}
}
