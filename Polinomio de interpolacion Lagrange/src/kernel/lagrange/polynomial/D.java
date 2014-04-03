package kernel.lagrange.polynomial;

public class D {

	private L minuend;
	private L subtrahend;
	private float distance = 0;

	public D(Point[] points, L l, L subL) {
		this.minuend = l;
		this.subtrahend = subL;

		Math math = new Math();

		for (int k = 0; k < points.length - 1; k++) {
			float part1 = math.solve(points[k].getX(), "x", minuend.getxNumeratorResult()) / minuend.getxDenominatorResult();
			float part2 = math.solve(points[k].getX(), "x", subtrahend.getxNumeratorResult()) / subtrahend.getxDenominatorResult();
			distance += (part1 - part2);
		}

		distance = math.absoluteValue(distance);

		distance /= points.length;
	}

	public L getMinuend() {
		return minuend;
	}

	public L getSubtrahend() {
		return subtrahend;
	}

	public float getDistance() {
		return distance;
	}

}
