package grafo.ordenado;

public class Vertice {
	String etiqueta;

	public Vertice(String etiqueta) {
		super();
		this.etiqueta = etiqueta;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public String toString() {
		return this.etiqueta;
	}

}
