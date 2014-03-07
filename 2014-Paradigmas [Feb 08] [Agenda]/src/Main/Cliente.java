package Main;

public class Cliente extends Persona {
	private int telefono;

	public Cliente(String name, String address, int telefono) {
		super(name, address);
		this.telefono = telefono;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
