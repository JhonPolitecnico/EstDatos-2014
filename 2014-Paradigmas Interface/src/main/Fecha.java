package main;

public class Fecha implements Comparable, Almacenable {

	int a�o;
	int mes;
	int dia;

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

		if (of.getA�o() != this.getA�o() || of.getMes() != this.getMes() || of.getDia() != this.getDia())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		if (of.getA�o() < this.getA�o())
			return false;

		if (of.getMes() < this.getMes())
			return false;

		if (of.getDia() < this.getDia())
			return false;

		return true;
	}

	@Override
	public boolean menorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		if (of.getA�o() > this.getA�o())
			return false;

		if (of.getMes() > this.getMes())
			return false;

		if (of.getDia() > this.getDia())
			return false;

		return true;
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
