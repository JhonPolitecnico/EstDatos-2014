package ui.tic.tac.toe;

import kernel.tic.tac.toe.Position;

public class ButtonData {

	private Position position;
	private boolean isClicked = false;

	public ButtonData(Position position) {
		super();
		this.position = position;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void clicked() {
		this.isClicked = true;
	}

	public Position getPosition() {
		return position;
	}

}
