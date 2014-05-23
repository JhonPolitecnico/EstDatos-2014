package main;

public class Main {

	public static void main(String[] args) {

		int[][] ok = new int[9][1];

		System.out.print("0");
		
		for (int i = 0; i < ok[0].length; i++)
			System.out.print("--");

		System.out.println("----> Eje X -> Columna j");

		for (int[] i : ok) {
			System.out.print("| ");
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		System.out.println("|\n|\nV");
		System.out.println("Eje Y -> Fila i");

	}

}
