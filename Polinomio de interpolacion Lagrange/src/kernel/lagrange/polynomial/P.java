package kernel.lagrange.polynomial;

public class P {

	private PSub[] parts;

	public P(L[] ls, Point[] points) {
		parts = new PSub[ls.length];
		for (int i = 0; i < points.length; i++) {
			parts[i] = new PSub(points[i].getY(), ls[i]);
		}
	}

	@Override
	public String toString() {
		String sRet = "";
		PSub part = null;

		for (int i = 0; i < parts.length; i++) {
			part = parts[i];
			sRet += part.getMultiplier().toString();
		}

		sRet += "Polinomio de interpolacion de Lagrange: \n";
		sRet += "P(x) = ";

		// Generar funcion P(x)
		for (int i = 0; i < parts.length; i++) {
			part = parts[i];
			sRet += "(" + part.getMultiplicand() + " * L" + part.getMultiplier().getId() + ")";
			if (i != parts.length - 1)
				sRet += " + ";
		}
		sRet += "\n";
		return sRet;
	}

	public PSub[] getParts() {
		return parts;
	}

}
