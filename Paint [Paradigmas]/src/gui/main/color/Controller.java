package gui.main.color;

import java.awt.Color;

public class Controller {

	private Color state;
	private gui.main.Controller main;

	public Controller(gui.main.Controller main) {
		this.main = main;
		this.state = Color.WHITE;
		this.setEnabled(this.state);
	}

	public Color getState() {
		return state;
	}

	public void setState(Color state) {
		this.state = state;
		this.setEnabled(this.state);
	}

	private void setEnabled(Color state) {
		this.main.getBtnBlack().setEnabled(state == Color.BLACK);
		this.main.getBtnBlue().setEnabled(state == Color.BLUE);
		this.main.getBtnGreen().setEnabled(state == Color.GREEN);
		this.main.getBtnOrange().setEnabled(state == Color.ORANGE);
		this.main.getBtnRed().setEnabled(state == Color.RED);
		this.main.getBtnWhite().setEnabled(state == Color.WHITE);
	}
}
