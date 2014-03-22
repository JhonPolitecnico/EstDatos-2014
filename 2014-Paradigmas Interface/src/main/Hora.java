package main;

public class Hora implements Comparable, Almacenable {

	private int hora;
	private int minuto;
	private int segundo;

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

	public Hora(int hora, int minuto, int segundo) {
		super();
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	@Override
	public boolean igualQue(Object o) {
		if (!(o instanceof Hora))
			return false;

		Hora of = (Hora) o;

		// Si algún dato no es igual, entonces, la hora no es igual
		if (of.getHora() != this.getHora() || of.getMinuto() != this.getMinuto() || of.getSegundo() != this.getSegundo())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Hora))
			return false;

		Hora of = (Hora) o;

		// Si la hora es mayor, el resto también lo es
		if (this.getHora() > of.getHora())
			return true;

		// Si no, entonces, o es igual, o es menor

		// Si es igual, entonces analizar minutos y segundos
		if (this.getHora() == of.getHora()) {

			// Si el minuto es mayor, el resto también lo es
			if (of.getMinuto() > of.getMinuto())
				return true;

			// Si no, entonces, o es igual, o es menor

			// Si es igual, entonces analizar segundos
			if (this.getMinuto() == of.getMinuto()) {

				// Si al final, el "segundo" es mayor, todo es mayor
				if (this.getSegundo() > of.getSegundo())
					return true;

			}
		}

		// Algo no es mayor
		return false;
	}

	@Override
	public boolean menorQue(Object o) {
		if (!(o instanceof Hora))
			return false;

		Hora of = (Hora) o;

		// Si la hora es menor, el resto también lo es
		if (this.getHora() < of.getHora())
			return true;

		// Si no, entonces, o es igual, o es mayor

		// Si es igual, entonces analizar minutos y segundos
		if (this.getHora() == of.getHora()) {

			// Si el minuto es menor, el resto también lo es
			if (of.getMinuto() < of.getMinuto())
				return true;

			// Si no, entonces, o es igual, o es mayor

			// Si es igual, entonces analizar segundos
			if (this.getMinuto() == of.getMinuto()) {

				// Si al final, el "segundo" es menor, todo es menor
				if (this.getSegundo() < of.getSegundo())
					return true;

			}
		}

		// Algo no es menor
		return false;
	}

	@Override
	public boolean diferenteQue(Object o) {
		return !(o instanceof Hora);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

}
