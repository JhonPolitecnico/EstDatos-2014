package main;

public class Fecha implements Comparable, Almacenable {

	private int año;
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

		// Si algún dato no es igual, entonces, la Fecha no es igual
		if (of.getAño() != this.getAño() || of.getMes() != this.getMes() || of.getDia() != this.getDia())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Fecha))
			return false;

		Fecha of = (Fecha) o;

		// Si el año es mayor, el resto también lo es
		if (this.getAño() > of.getAño())
			return true;

		// Si no, entonces, o es igual, o es menor

		// Si es igual, entonces analizar mes y día
		if (this.getAño() == of.getAño()) {

			// Si el mes es mayor, el resto también lo es
			if (of.getMes() > of.getMes())
				return true;

			// Si no, entonces, o es igual, o es menor

			// Si es igual, entonces analizar días
			if (this.getMes() == of.getMes()) {

				// Si al final, el día es mayor, todo es mayor
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

		// Si el año es menor, el resto también lo es
		if (this.getAño() < of.getAño())
			return true;

		// Si no, entonces, o es igual, o es mayor

		// Si es igual, entonces analizar mes y día
		if (this.getAño() == of.getAño()) {

			// Si el mes es menor, el resto también lo es
			if (of.getMes() < of.getMes())
				return true;

			// Si no, entonces, o es igual, o es mayor

			// Si es igual, entonces analizar días
			if (this.getMes() == of.getMes()) {

				// Si al final, el día es menor, todo es menor
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
