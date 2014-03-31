package kernel.lagrange.polynomial;

public class L {

	// El numero del polinomio de Lagrange
	private int id;

	// Numerador del resultado del polinomio de Lagrange
	private String xNumeratorResult = "";

	// Denominador del resultado del polinomio de Lagrange
	private float xDenominatorResult = 1;

	// Generar un polinomio de Lagrange para el punto $id
	public L(int id, Point[] points) {
		super();
		this.id = id;

		// Generar el polinomio de Lagrange
		Point point = null;
		for (int i = 0; i < points.length; i++) {
			// No multiplicarnos a nosotros mismos
			if (i == this.id)
				continue;

			point = points[i];

			// Ej: Caso particular "L1" ==>
			//
			// Al polinomio correspondiente al primer punto, le llamamos "L1" y se calcula como el producto de
			// (x-x2) por (x-x3). Si hubiera mas puntos,
			// multiplicariamos tambien por (x-x4), por (x-x5),
			// etc…
			//
			// Todos los (x-xk) posibles menos (x-x1) porque estamos con el polinomio L1.
			this.xNumeratorResult += "(x - " + point.getX() + ")";
			// Y ahora dividimos por la misma expresión que tenemos en el numerador, pero sustituyendo x por x1. así:
			this.xDenominatorResult *= (points[this.id].getX() - point.getX());
		}

	}

	@Override
	public String toString() {
		String sRet = "L" + this.id + ":\n";
		sRet += "\t" + this.xNumeratorResult + "\n";
		sRet += "\t" + "________________________\n";
		sRet += "\t\t" + this.xDenominatorResult + "\n\n";
		return sRet;
	}

	public int getId() {
		return id;
	}

	public String getxNumeratorResult() {
		return xNumeratorResult;
	}

	public float getxDenominatorResult() {
		return xDenominatorResult;
	}

}
