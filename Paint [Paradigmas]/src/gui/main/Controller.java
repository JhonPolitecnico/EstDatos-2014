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
import gui.main.mouse.ChangeColor;
import gui.main.mouse.Exit;
import gui.main.mouse.Load;
import gui.main.mouse.New;
import gui.main.mouse.Save;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;

import utils.Utils;

public class Controller extends Main {

	private static final long serialVersionUID = 163143371781152352L;

	private gui.main.brush.Controller brush;
	private gui.main.color.Controller color;

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
		this.color = new gui.main.color.Controller(this);

		super.workspace.setMain(this);

		/*
		 * Set properties
		 */

		this.btnLine.setData(Brush.LINE);
		this.btnTriangle.setData(Brush.TRIANGLE);
		this.btnSquare.setData(Brush.SQUARE);
		this.btnPolygon.setData(Brush.POLYGON);
		this.btnBrush.setData(Brush.BRUSH);

		this.btnBlack.setData(Color.BLACK);
		this.btnBlue.setData(Color.BLUE);
		this.btnGreen.setData(Color.GREEN);
		this.btnOrange.setData(Color.ORANGE);
		this.btnRed.setData(Color.RED);
		this.btnWhite.setData(Color.WHITE);

		/*
		 * Events
		 */

		this.mntmNew.addActionListener(new New(this.workspace));
		this.mntmLoad.addActionListener(new Load(this, this.workspace));
		this.mntmSave.addActionListener(new Save(this, this.workspace));
		this.mntmExit.addActionListener(new Exit());

		this.btnLine.addMouseListener(new ChangeBrush(this.brush));
		this.btnTriangle.addMouseListener(new ChangeBrush(this.brush));
		this.btnSquare.addMouseListener(new ChangeBrush(this.brush));
		this.btnPolygon.addMouseListener(new ChangeBrush(this.brush));
		this.btnBrush.addMouseListener(new ChangeBrush(this.brush));

		this.btnBlack.addMouseListener(new ChangeColor(this.color));
		this.btnBlue.addMouseListener(new ChangeColor(this.color));
		this.btnGreen.addMouseListener(new ChangeColor(this.color));
		this.btnOrange.addMouseListener(new ChangeColor(this.color));
		this.btnRed.addMouseListener(new ChangeColor(this.color));
		this.btnWhite.addMouseListener(new ChangeColor(this.color));
	}

	/*
	 * Getters & Setters
	 */

	public gui.main.brush.Controller getBrush() {
		return this.brush;
	}

	public gui.main.color.Controller getColor() {
		return this.color;
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

	public JButton getBtnBrush() {
		return super.btnBrush;
	}
}
