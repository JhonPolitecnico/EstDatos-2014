package ui.tic.tac.toe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import swing.jDataButton.JDataButton;
import kernel.tic.tac.toe.Position;
import kernel.tic.tac.toe.TicTacToe;

public class UI {

	private TicTacToe juego;

	private JFrame frame;
	private JDataButton BTN_00;
	private JDataButton BTN_01;
	private JDataButton BTN_02;

	private JDataButton BTN_10;
	private JDataButton BTN_11;
	private JDataButton BTN_12;

	private JDataButton BTN_20;
	private JDataButton BTN_21;
	private JDataButton BTN_22;

	private UI self = this;

	public UI(JFrame frame, JDataButton bTN_00, JDataButton bTN_01, JDataButton bTN_02, JDataButton bTN_10, JDataButton bTN_11, JDataButton bTN_12, JDataButton bTN_20, JDataButton bTN_21,
			JDataButton bTN_22) {
		super();

		this.juego = new TicTacToe(new Callable<Void>() {
			public Void call() {
				self.onTerminated();
				return null;
			}
		});

		/*
		 * Handles
		 */
		this.frame = frame;
		BTN_00 = bTN_00;
		BTN_01 = bTN_01;
		BTN_02 = bTN_02;

		BTN_10 = bTN_10;
		BTN_11 = bTN_11;
		BTN_12 = bTN_12;

		BTN_20 = bTN_20;
		BTN_21 = bTN_21;
		BTN_22 = bTN_22;

		/*
		 * Events
		 */
		BTN_00.addMouseListener(this.newMouseEvent());
		BTN_01.addMouseListener(this.newMouseEvent());
		BTN_02.addMouseListener(this.newMouseEvent());

		BTN_10.addMouseListener(this.newMouseEvent());
		BTN_11.addMouseListener(this.newMouseEvent());
		BTN_12.addMouseListener(this.newMouseEvent());

		BTN_20.addMouseListener(this.newMouseEvent());
		BTN_21.addMouseListener(this.newMouseEvent());
		BTN_22.addMouseListener(this.newMouseEvent());

		// New game
		this.newGame();
	}

	private MouseAdapter newMouseEvent() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				self.onClick(e);
			}
		};
	}

	private String getPath() {
		return System.getProperty("user.dir");
	}

	public ImageIcon getImageOfV() {
		return new ImageIcon(this.getPath() + "\\img\\v.png");
	}

	private ImageIcon getImageOfX() {
		return new ImageIcon(this.getPath() + "\\img\\x.png");
	}

	private ImageIcon getImageOfO() {
		return new ImageIcon(this.getPath() + "\\img\\o.png");
	}

	private void setTitle() {
		switch (this.juego.getState()) {
		case DRAW:
			this.frame.setTitle("Ninguno gano");
			break;

		case WIN_X:
			this.frame.setTitle("Gano X!!!");
			break;

		case WIN_O:
			this.frame.setTitle("Gano O!!!");
			break;

		case ONGOING:
			this.frame.setTitle("Turno " + this.juego.getTurnoActual());
			break;

		}
	}

	private void newGame() {

		this.juego.reset();

		/*
		 * Data
		 */
		BTN_00.setData(new ButtonData(Position.P00));
		BTN_01.setData(new ButtonData(Position.P01));
		BTN_02.setData(new ButtonData(Position.P02));

		BTN_10.setData(new ButtonData(Position.P10));
		BTN_11.setData(new ButtonData(Position.P11));
		BTN_12.setData(new ButtonData(Position.P12));

		BTN_20.setData(new ButtonData(Position.P20));
		BTN_21.setData(new ButtonData(Position.P21));
		BTN_22.setData(new ButtonData(Position.P22));

		/*
		 * Empty images
		 */
		BTN_00.setIcon(this.getImageOfV());
		BTN_01.setIcon(this.getImageOfV());
		BTN_02.setIcon(this.getImageOfV());

		BTN_10.setIcon(this.getImageOfV());
		BTN_11.setIcon(this.getImageOfV());
		BTN_12.setIcon(this.getImageOfV());

		BTN_20.setIcon(this.getImageOfV());
		BTN_21.setIcon(this.getImageOfV());
		BTN_22.setIcon(this.getImageOfV());

		/*
		 * Disable buttons
		 */
		this.disableButtons(false);

		/*
		 * Title
		 */
		this.setTitle();
	}

	private void onTerminated() {
		this.disableButtons(true);
	}

	private void disableButtons(boolean disable) {
		disable = !disable;
		BTN_00.setEnabled(disable);
		BTN_01.setEnabled(disable);
		BTN_02.setEnabled(disable);

		BTN_10.setEnabled(disable);
		BTN_11.setEnabled(disable);
		BTN_12.setEnabled(disable);

		BTN_20.setEnabled(disable);
		BTN_21.setEnabled(disable);
		BTN_22.setEnabled(disable);
	}

	public void onClick(MouseEvent e) {

		if (!(e.getComponent() instanceof JDataButton))
			return;

		JDataButton button = (JDataButton) e.getComponent();

		if (!button.isEnabled())
			return;

		if (!(button.getData() instanceof ButtonData))
			return;

		ButtonData data = (ButtonData) button.getData();

		if (data.isClicked())
			return;

		if (this.juego.isX())
			button.setIcon(this.getImageOfX());
		else
			button.setIcon(this.getImageOfO());

		data.clicked();
		this.juego.play(data.getPosition());
		this.setTitle();

	}

	public void reset() {
		this.newGame();
	}

}
