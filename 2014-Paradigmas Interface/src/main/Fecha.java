package main;

public class Fecha implements Comparable, Almacenable {

	private int a�o;
	private int mes;
	private int dia;

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean igualQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		// Si alg�n dato no es igual, entonces, la Fecha no es igual
		if (of.getA�o() != this.getA�o() || of.getMes() != this.getMes() || of.getDia() != this.getDia())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		// Si el a�o es mayor, el resto tambi�n lo es
		if (this.getA�o() > of.getA�o())
			return true;

		// Si no, entonces, o es igual, o es menor

		// Si es igual, entonces analizar mes y d�a
		if (this.getA�o() == of.getA�o()) {

			// Si el mes es mayor, el resto tambi�n lo es
			if (of.getMes() > of.getMes())
				return true;

			// Si no, entonces, o es igual, o es menor

			// Si es igual, entonces analizar d�as
			if (this.getMes() == of.getMes()) {

				// Si al final, el d�a es mayor, todo es mayor
				if (this.getDia() > of.getDia())
					return true;

			}
		}

		// Algo no es mayor
		return false;
	}

	@Override
	public boolean menorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		// Si el a�o es menor, el resto tambi�n lo es
		if (this.getA�o() < of.getA�o())
			return true;

		// Si no, entonces, o es igual, o es mayor

		// Si es igual, entonces analizar mes y d�a
		if (this.getA�o() == of.getA�o()) {

			// Si el mes es menor, el resto tambi�n lo es
			if (of.getMes() < of.getMes())
				return true;

			// Si no, entonces, o es igual, o es mayor

			// Si es igual, entonces analizar d�as
			if (this.getMes() == of.getMes()) {

				// Si al final, el d�a es menor, todo es menor
				if (this.getDia() < of.getDia())
					return true;

			}
		}

		// Algo no es menor
		return false;
	}

	@Override
	public boolean diferenteQue(Object o) {
		return !(o instanceof Fecha);
	}

	public Fecha(int a�o, int mes, int dia) {
		super();
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

}
