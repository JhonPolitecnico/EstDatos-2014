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

import library.Library;
import serializer.engine.Serializer;
import user.Admin;
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

		super.setTitle("Jhon's Estate Sales");
		super.lblLogo.setIcon(Utils.getImage("logo.png"));
		Utils.centerFrame(this);

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
		}

		super.btnExit.addMouseListener(new Exit());
		super.btnGuest.addMouseListener(new Guest(this));
		super.btnLogin.addMouseListener(new gui.login.mouse.Login(this));
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
