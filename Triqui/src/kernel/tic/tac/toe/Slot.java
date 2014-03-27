package kernel.tic.tac.toe;

public class Slot {
	private Position position;
	private XorO value;
	private boolean empty = true;

	public Slot(Position position) {
		super();
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setValue(XorO value) {
		this.value = value;
		this.empty = false;
	}

	public XorO getValue() {
		return (!this.empty) ? this.value : null;
	}

	public boolean isX() {
		return (this.value == XorO.X && !this.empty);
	}

	public boolean isO() {
		return (this.value == XorO.O && !this.empty);
	}
}
