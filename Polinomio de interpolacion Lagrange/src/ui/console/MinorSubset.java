package ui.console;

import kernel.lagrange.polynomial.Point;

public class MinorSubset {
	private float distance;
	private Point[] points;

	public MinorSubset(float distance, Point[] points) {
		super();
		this.distance = distance;
		this.points = points;
	}

	public float getDistance() {
		return distance;
	}

	public Point[] getPoints() {
		return points;
	}

}
