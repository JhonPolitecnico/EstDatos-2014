package gui.main;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import gui.main.brush.Brush;
import gui.main.mouse.ChangeBrush;

import java.awt.EventQueue;

import javax.swing.JButton;

import utils.Utils;

public class Controller extends Main {

	private static final long serialVersionUID = 163143371781152352L;

	private gui.main.brush.Controller brush;

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

		this.brush = new gui.main.brush.Controller(this);

		super.workspace.setMain(this);

		this.btnLine.setData(Brush.LINE);
		this.btnTriangle.setData(Brush.TRIANGLE);
		this.btnSquare.setData(Brush.SQUARE);
		this.btnPolygon.setData(Brush.POLYGON);

		/*
		 * Events
		 */

		this.btnLine.addMouseListener(new ChangeBrush(this.brush));
		this.btnTriangle.addMouseListener(new ChangeBrush(this.brush));
		this.btnSquare.addMouseListener(new ChangeBrush(this.brush));
		this.btnPolygon.addMouseListener(new ChangeBrush(this.brush));
	}

	/*
	 * Getters & Setters
	 */

	public gui.main.brush.Controller getBrush() {
		return brush;
	}

	public JButton getBtnWhite() {
		return super.btnWhite;
	}

	public JButton getBtnBlack() {
		return super.btnBlack;
	}

	public JButton getBtnRed() {
		return super.btnRed;
	}

	public JButton getBtnGreen() {
		return super.btnGreen;
	}

	public JButton getBtnBlue() {
		return super.btnBlue;
	}

	public JButton getBtnOrange() {
		return super.btnOrange;
	}

	public JButton getBtnLine() {
		return super.btnLine;
	}

	public JButton getBtnTriangle() {
		return super.btnTriangle;
	}

	public JButton getBtnSquare() {
		return super.btnSquare;
	}

	public JButton getBtnPolygon() {
		return super.btnPolygon;
	}
}
