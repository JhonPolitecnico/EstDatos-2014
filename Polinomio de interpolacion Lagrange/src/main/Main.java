package main;

import kernel.lagrange.polynomial.D;
import kernel.lagrange.polynomial.L;
import kernel.lagrange.polynomial.Math;
import kernel.lagrange.polynomial.P;
import kernel.lagrange.polynomial.Point;
import ui.console.UI;

public class Main {

	/*
	 * Integrantes: |- Jhon Jairo Eslava +++ 1310012946 |- Juan Guillermo Celemin +++ 1210010657 |- Michael Roberto Torres +++ 1310019024 |- Jabier Alejandro Sierra +++ 0612040895
	 * 
	 * Referencia: http://blogs.20minutos.es/mati-una-profesora-muy-particular/tag/polinomios-de-lagrange/
	 */

	public static void main(String[] args) {

		/*
		 * UI UI = new UI(); UI.on();
		 */

		L[] l = new L[3];
		Point[] points = new Point[3];
		P p;
		Math math = new Math();

		points[0] = new Point(0, 7);
		points[1] = new Point(3, 7);
		points[2] = new Point(6, 6);
		l[0] = new L(0, points);
		l[1] = new L(1, points);
		l[2] = new L(2, points);
		p = new P(l, points);

		System.out.println(p.toString());

		D d = new D(points, l[0], l[1]);

	}
}
