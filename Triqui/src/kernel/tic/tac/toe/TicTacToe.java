package kernel.tic.tac.toe;

import java.util.concurrent.Callable;

public class TicTacToe {

	private XorO turnoActual;
	private Slot[] grid = new Slot[9];
	private State state;
	private Callable<?> onTerminated;

	public TicTacToe(Callable<?> onTerminated) {
		super();

		this.onTerminated = onTerminated;
		this.newGame();

	}

	public void reset() {
		this.newGame();
	}

	private void newGame() {
		// Set positions
		for (int i = 0; i < grid.length; i++)
			grid[i] = new Slot(Position.values()[i]);

		this.turnoActual = XorO.X;
		this.state = State.ONGOING;
	}

	private void fillSlot(Position position, XorO value) {
		for (int i = 0; i < grid.length; i++)
			if (grid[i].getPosition() == position) {
				grid[i].setValue(value);
				System.out.println(position);
				break;
			}
	}

	private Slot getSlot(Position position) {
		for (int i = 0; i < grid.length; i++)
			if (grid[i].getPosition() == position)
				return grid[i];

		return null;
	}

	private boolean equalSlotValue(Position position, XorO value) {
		Slot slot = this.getSlot(position);
		return (slot.getValue() != null) ? slot.getValue() == value : false;
	}

	private boolean checkOnGoing() {
		// onTerminated
		if (this.getState() != State.ONGOING) {
			try {
				this.onTerminated.call();
				return false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public State getState() {
		return this.state;
	}

	/*
	 * Play game!
	 */
	public void play(Position position) {

		// No more plays, then it's over
		if (!this.checkOnGoing())
			return;

		this.fillSlot(position, this.turnoActual);

		// Check winner or tie
		Check: {
			XorO actual;
			for (int i = 0; i < XorO.values().length; i++) {
				actual = XorO.values()[i];

				// Filas
				for (int j = 0; j < 9; j += 3) {

					if (this.equalSlotValue(Position.values()[j], actual) && this.equalSlotValue(Position.values()[j + 1], actual) && this.equalSlotValue(Position.values()[j + 2], actual)) {
						this.state = (actual == XorO.X) ? State.WIN_X : State.WIN_O;
						break Check;
					}
				}

				// Columnas
				for (int j = 0; j < 3; j++) {
					if (this.equalSlotValue(Position.values()[j], actual) && this.equalSlotValue(Position.values()[j + 3], actual) && this.equalSlotValue(Position.values()[j + 6], actual)) {
						this.state = (actual == XorO.X) ? State.WIN_X : State.WIN_O;
						break Check;
					}
				}

				// Diagonal principal
				if (this.equalSlotValue(Position.P00, actual) && this.equalSlotValue(Position.P11, actual) && this.equalSlotValue(Position.P22, actual)) {
					this.state = (actual == XorO.X) ? State.WIN_X : State.WIN_O;
					break Check;
				}

				// Diagonal inversa
				if (this.equalSlotValue(Position.P02, actual) && this.equalSlotValue(Position.P11, actual) && this.equalSlotValue(Position.P20, actual)) {
					this.state = (actual == XorO.X) ? State.WIN_X : State.WIN_O;
					break Check;
				}
			}
		}

		// onTerminated
		if (!this.checkOnGoing())
			return;

		if (this.isX())
			turnoActual = XorO.O;
		else
			turnoActual = XorO.X;
	}

	public boolean isX() {
		return (this.turnoActual == XorO.X);
	}

	public boolean isO() {
		return (this.turnoActual == XorO.O);
	}

	public XorO getTurnoActual() {
		return turnoActual;
	}

}
