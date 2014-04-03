package kernel.lagrange.polynomial;

public class D {

	private P minuend;
	private P subtrahend;
	private float distance = 0;

	// Formula: http://prntscr.com/36n0f2
	public D(Point[] points, P p, P subP) {
		this.minuend = p;
		this.subtrahend = subP;

		// Sumatoria con "k=0" hasta "n-1"
		for (int k = 0; k < points.length; k++) {
			// |La(X0) - Li(X0)| + |La(X1) - Li(X1)| + ... + |La(Xk) - Li(Xk)|;
			System.out.println(Math.absoluteValue(Math.solveLagrangePolynomial(minuend, points[k].getX()) - Math.solveLagrangePolynomial(subtrahend, points[k].getX())));
			distance += Math.absoluteValue(Math.solveLagrangePolynomial(minuend, points[k].getX()) - Math.solveLagrangePolynomial(subtrahend, points[k].getX()));
		}

		// Sumatoria / n;
		distance /= points.length;
	}

	public P getMinuend() {
		return minuend;
	}

	public P getSubtrahend() {
		return subtrahend;
	}

	public float getDistance() {
		return distance;
	}

}
