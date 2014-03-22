package main;

public class Hora implements Comparable, Almacenable {

	int hora;
	int minuto;
	int segundo;

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

		if (of.getHora() != this.getHora() || of.getMinuto() != this.getMinuto() || of.getSegundo() != this.getSegundo())
			return false;

		return true;
	}

	@Override
	public boolean mayorQue(Object o) {
		if (!(o instanceof Hora))
			return false;

		Hora of = (Hora) o;

		if (of.getHora() < this.getHora())
			return false;

		if (of.getMinuto() < this.getMinuto())
			return false;

		if (of.getSegundo() < this.getSegundo())
			return false;

		return true;
	}

	@Override
	public boolean menorQue(Object o) {
		if (!(o instanceof Hora))
			return false;

		Hora of = (Hora) o;

		if (of.getHora() > this.getHora())
			return false;

		if (of.getMinuto() > this.getMinuto())
			return false;

		if (of.getSegundo() > this.getSegundo())
			return false;

		return true;
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
