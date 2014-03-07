package Main;

public class Main {

	// @formatter:off
	static int[][] tablero={{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0}};
	// @formatter:on

	static String[] sVars = { "MURIO", "ESCAPO" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(iniciar(2, 2));
		System.out.println("TABLERO FINAL ==> ");
		printTablero();
	}

	public static String iniciar(int x, int y) {
		// Marco Mi Recorrido...
		tablero[x][y] = 1;
		System.out.println("TABLERO ORIGINAL ==> ");
		printTablero();
		return laberinto(x, y);
	}

	public static String laberinto(int x, int y) {

		// @formatter:off
		/**
		 * Primer grupo, dos arriba uno al lado
				M M     M M
				  M     M
				  X     X
				  
				  X     X
				  M     M
				M M     M M
		 */
		// @formatter:on

		// @formatter:off
		/**
		 * Arriba Izquierda
				M M
				  M
				  X
		 */
		// @formatter:on
		if (esValido(izq1(y), arr2(x))) {
			System.out.print("Arriba 2 Izquierda 1 ==> ");
			return move(izq1(y), arr2(x));
		}

		// @formatter:off
		/**
		 * Abajo Derecha
                  X
				  M
				  M M
		 */
		// @formatter:on
		if (esValido(der1(y), aba2(x))) {
			System.out.print("Abajo 2 Derecha 1 ==> ");
			return move(der1(y), aba2(x));
		}

		// @formatter:off
		/**
		 * Arriba Derecha
				  M M
				  M
				  X
		 */
		// @formatter:on
		if (esValido(der1(y), arr2(x))) {
			System.out.print("Arriba 2 Derecha 1 ==> ");
			return move(der1(y), arr2(x));
		}

		// @formatter:off
		/**
		 * Abajo Izquierda
                  X
				  M
				M M
		 */
		// @formatter:on
		if (esValido(izq1(y), aba2(x))) {
			System.out.print("Abajo 2 Izquierda 1 ==> ");
			return move(izq1(y), aba2(x));
		}

		// ///////////////////////////////////////////////////////////////////////////////

		// @formatter:off
		/**
		 * Segundo grupo, uno arriba dos al lado
			  M M M     M M M
			      X     X
             
			      X     X
			  M M M     M M M
		 */
		// @formatter:on

		// @formatter:off
		/**
		 * Arriba Izquierda
		      M M M
				  X
		 */
		// @formatter:on
		if (esValido(izq2(y), arr1(x))) {
			System.out.print("Arriba 1 Izquierda 2 ==> ");
			return move(izq2(y), arr1(x));
		}

		// @formatter:off
		/**
		 * Abajo Derecha
				  X
				  M M M
		 */
		// @formatter:on
		if (esValido(der2(y), aba1(x))) {
			System.out.print("Abajo 1 Derecha 2 ==> ");
			return move(der2(y), aba1(x));
		}

		// @formatter:off
		/**
		 * Arriba Derecha
				  M M M
				  X
		 */
		// @formatter:on
		if (esValido(der2(y), arr1(x))) {
			System.out.print("Arriba 1 Derecha 2 ==> ");
			return move(der2(y), arr1(x));
		}

		// @formatter:off
		/**
		 * Abajo Izquierda
				  X
			  M M M
		 */
		// @formatter:on
		if (esValido(izq2(y), aba1(x))) {
			System.out.print("Abajo 1 Izquierda 2 ==> ");
			return move(izq2(y), aba1(x));
		}

		return "Caballo atrapado";
	}

	public static String move(int y, int x) {
		System.out.println(x + ", " + y);
		// Marco Mi Recorrido...
		tablero[x][y] = -1;
		// Seguir moviendome...
		return laberinto(x, y);
	}

	/**
	 * Primer Grupo De Movimientos
	 * 
	 * Auxuliares (no equibocarse)
	 */
	private static int arr2(int x) {
		return x - 2;
	}

	private static int aba2(int x) {
		return x + 2;
	}

	private static int izq1(int y) {
		return y - 1;
	}

	private static int der1(int y) {
		return y + 1;
	}

	/**
	 * Segundo Grupo De Movimientos
	 * 
	 * Auxuliares (no equibocarse)
	 */
	private static int arr1(int x) {
		return x - 1;
	}

	private static int aba1(int x) {
		return x + 1;
	}

	private static int izq2(int y) {
		return y - 2;
	}

	private static int der2(int y) {
		return y + 2;
	}

	// (no existe? ya lo visite?) == False, (puedo moverme aquí?) == True
	public static boolean esValido(int y, int x) {
		try {
			return !(tablero[x][y] == 1 || tablero[x][y] == -1);
		} catch (Exception e) {
			return false;
		}
	}

	// Auxiliar
	public static void printTablero() {
		for (int[] Ints : tablero) {
			for (int Int : Ints)
				System.out.print(Int + "\t | ");
			System.out.println("");
		}
	}

}
