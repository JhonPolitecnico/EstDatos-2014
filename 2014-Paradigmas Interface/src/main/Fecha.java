package main;

public class Fecha implements Comparable, Almacenable {

	int año;
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

		if (of.getAño() != this.getAño() || of.getMes() != this.getMes() || of.getDia() != this.getDia())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		if (of.getAño() < this.getAño())
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

		if (of.getAño() > this.getAño())
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

	public Fecha(int año, int mes, int dia) {
		super();
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
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
