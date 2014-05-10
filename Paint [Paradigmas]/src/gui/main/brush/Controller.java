package gui.main.brush;

public class Controller {

	private Brush state;
	private gui.main.Controller main;

	public Controller(gui.main.Controller main) {
		this.main = main;
		this.state = Brush.LINE;
	}

	public Brush getState() {
		return state;
	}

	public void setState(Brush state) {
		this.state = state;
		this.setEnabled(this.state);
		switch (this.state) {

		case LINE:
			break;

		case POLYGON:

			break;

		case SQUARE:

			break;

		case TRIANGLE:

			break;
		}

	}

	private void setEnabled(Brush state) {
		this.main.getBtnLine().setEnabled(((state.getValue() & Brush.LINE.getValue()) != 0) ? true : false);
		this.main.getBtnTriangle().setEnabled(((state.getValue() & Brush.TRIANGLE.getValue()) != 0) ? true : false);
		this.main.getBtnSquare().setEnabled(((state.getValue() & Brush.SQUARE.getValue()) != 0) ? true : false);
		this.main.getBtnPolygon().setEnabled(((state.getValue() & Brush.POLYGON.getValue()) != 0) ? true : false);
	}
}
