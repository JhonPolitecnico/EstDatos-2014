package model;

public class Estudiante {

	private String nombre;
	private int codigo;

	public Estudiante(String nombre, int codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return this.codigo % 30;
	}

	@Override
	public String toString() {
		return "nombre: " + this.nombre + " codigo: " + this.codigo + " hashcode: " + this.hashCode();
	}
}
