package Main;

import java.util.Scanner;

public class Main {

	/*
	 * Loops (with solutions) For exercises 1 to 15, indicate the output that will be produced. Assume the following declarations are made just before each exercise. That is, assume these
	 * initializations are in effect at the beginning of each problem:
	 */

	final static int MIN = 10, MAX = 20;
	final static int SENTINEL = 55;
	static int num = 15;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Objective: To express recursively all loops

		d18();

		if (true)
			return;

		// trece(num);

		/**
		 * Simple
		 */
		log("one");
		one();
		reset();
		log("two");
		two();
		reset();
		log("three");
		three();
		reset();
		log("four");
		four();
		reset();
		log("five");
		five();
		reset();
		log("six");
		six();
		reset();
		log("seven");
		seven();
		reset();
		log("eight");
		eight();
		reset();

		/**
		 * correct the code and move to recursively
		 */
		log("twentynine");
		twentynine("Programacion");

	}

	public static void reset() {
		num = 15;
	}

	public static void log(String sStep) {
		System.out.println("Exercise " + sStep + ":");
	}

	public static void one() {
		if (num < MAX) {
			System.out.println(num);
			num++;
			one();
		}
	}

	public static void two() {
		if (num < MAX) {
			num++;
			System.out.println(num);
			two();
		}
	}

	public static void three() {
		num++;
		System.out.println(num);
		if (num <= MAX)
			three();
	}

	public static void four() {

		// Preserve Control
		if (num <= -9999)
			return;

		if (num < MAX) {
			num--;
			System.out.println(num);
			four();
		}
	}

	public static void five() {
		if (num > MIN) {
			System.out.println(num);
			num--;
			five();
		}
	}

	public static void six() {
		if (num < MAX) {
			System.out.println(num);
			num += 2;
			six();
		}
	}

	public static void seven() {
		if (num < MAX) {
			if (num % 2 == 0)
				System.out.println(num);
			num++;
			seven();
		}
	}

	public static void eight() {
		num++;
		if (num * 2 > MAX + num)
			System.out.println(num);
		if (num <= MAX)
			eight();
	}

	public static void once(int iPos) {
		if (iPos > 20)
			return;
		System.out.println(iPos);
		once(iPos + 4);
	}

	public static void doce(int iPos) {
		if (iPos > MAX)
			return;
		System.out.println(iPos);
		doce(iPos + 1);
	}

	public static void trece(int iPos) {
		if (iPos > MAX)
			return;
		if (iPos % 4 != 0)
			System.out.println(iPos);
		trece(iPos + 1);
	}

	public static String numerales(int iLen) {
		return numerales(iLen, 1);
	}

	public static String numerales(int iLen, int iPos) {
		return (iPos > iLen) ? "" : "#" + numerales(iLen, iPos + 1);
	}

	public static void catorce() {
		catorce(1);
	}

	public static void catorce(int iLine) {
		if (iLine > 7)
			return;
		System.out.print(numerales(5));
		System.out.println();
		catorce(iLine + 1);
	}

	public static String multi(int iLine) {
		return multi(iLine, 1);
	}

	public static String multi(int iLine, int iPos) {
		return (iPos > 5) ? "" : (iLine * iPos) + " " + multi(iLine, iPos + 1);
	}

	public static void quince() {
		quince(1);
	}

	public static void quince(int iLine) {
		if (iLine > 5)
			return;
		System.out.print(multi(iLine));
		System.out.println();
		quince(iLine + 1);
	}

	public static void dieciseis(int value) {
		Scanner sIn = new Scanner(System.in);

		if (value < 0)
			return;

		System.out.print("Enter a positive value:");
		value = sIn.nextInt();
		dieciseis(value);
	}

	public static void diecisiete(int value) {
		Scanner sIn = new Scanner(System.in);

		if (value % 2 != 0)
			return;

		System.out.print("Enter a even value:");
		value = sIn.nextInt();
		diecisiete(value);

	}

	public static void d18() {
		d18(SENTINEL - 999);
	}

	public static void d18(int value) {
		if (value == SENTINEL)
			return;

		Scanner sIn = new Scanner(System.in);

		System.out.print((value == SENTINEL - 999) ? "Enter a value:" : "Enter another value:");
		value = sIn.nextInt();
		d18(value);

	}

	// Overload
	public static String spaces(int iLen) {
		return spaces(iLen, 0);
	}

	// Write spaces in left position
	public static String spaces(int iLen, int iPos) {
		return (iLen == iPos) ? "" : (iPos > iLen) ? " " : " " + spaces(iLen, iPos + 1);
	}

	// Overload
	public static void twentynine(String sText) {
		twentynine(sText, 0);
	}

	public static void twentynine(String sText, int iLine) {
		if (iLine >= sText.length())
			return;
		System.out.print(spaces(iLine));
		System.out.println(sText.charAt(iLine));
		twentynine(sText, iLine + 1);
	}

}
