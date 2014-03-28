package kernel.tic.tac.toe;

public class Slot {
	private Position position;
	private Chip value;
	private boolean empty = true;

	public Slot(Position position) {
		super();
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setValue(Chip value) {
		this.value = value;
		this.empty = false;
	}

	public boolean isEmpty() {
		return this.empty;
	}

	public Chip getValue() {
		return (!this.empty) ? this.value : null;
	}

	public boolean isX() {
		return (this.value == Chip.X && !this.empty);
	}

	public boolean isO() {
		return (this.value == Chip.O && !this.empty);
	}
}
