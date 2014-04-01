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
	private JDataButton[] buttons;

	private UI self = this;

	public UI(JFrame frame, JDataButton[] buttons) {
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
		this.buttons = buttons;

		/*
		 * Events
		 */
		for (int i = 0; i < this.buttons.length; i++)
			this.buttons[i].addMouseListener(this.newMouseEvent());

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
		for (int i = 0; i < this.buttons.length; i++)
			this.buttons[i].setData(new ButtonData(Position.values()[i]));

		/*
		 * Empty images
		 */
		for (int i = 0; i < this.buttons.length; i++)
			this.buttons[i].setIcon(this.getImageOfV());

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
		for (int i = 0; i < this.buttons.length; i++)
			this.buttons[i].setEnabled(disable);
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
