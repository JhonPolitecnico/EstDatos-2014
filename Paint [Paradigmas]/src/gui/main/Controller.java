package gui.main;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.EventQueue;

import utils.Utils;

public class Controller extends Main {

	private static final long serialVersionUID = 163143371781152352L;

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

		setTitle("Paint - Jhon Jairo Eslava");

		// Crear frame
		Utils.centerFrame(this);
	}

	/*
	 * Getters & Setters
	 */
}
