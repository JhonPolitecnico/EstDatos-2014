package gui.login;

import gui.login.mouse.Exit;
import gui.login.mouse.Guest;

import java.awt.EventQueue;

public class Controller extends Login {

	private static final long serialVersionUID = -2376869953031761690L;

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
		super.btnExit.addMouseListener(new Exit());
		super.btnGuest.addMouseListener(new Guest(this));
	}

}
