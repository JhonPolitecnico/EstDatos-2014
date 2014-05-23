package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *    0 1 2 3 4 5 6         -> Eje X -> j
 *    _ _ _ _ _ _ _ 
 * 0 | | | | | | | |
 *    - - - - - - -
 * 1 | | | | | | | |
 *    - - - - - - -
 * 2 | | | | | | | |
 *    - - - - - - -
 * 3 | | | | | | | |
 *    - - - - - - -
 * |
 * V
 * Eje Y -> i
 * 
 */

public class Laberinto {
	// tablero
	public static int MAX = 15;
	private String[][] tablero = new String[MAX][MAX];
	private boolean[][] visitadas = new boolean[MAX][MAX];
	private int salidax = 0;
	private int saliday = 0;
	private int llegadax = 0;
	private int llegaday = 0;
	// convenciones
	public static String VACIO = "1";
	public static String MURO = "0";
	public static String SALIDA = "2";
	public static String LLEGADA = "3";

	public static String CONVENCION_ARRIBA = "^";
	public static String CONVENCION_DERECHA = ">";
	public static String CONVENCION_ABAJO = "V";
	public static String CONVENCION_IZQUIERDA = "<";
	public static String[] DIRECCIONES = { CONVENCION_ARRIBA, CONVENCION_DERECHA, CONVENCION_ABAJO, CONVENCION_IZQUIERDA };

	// direcciones
	public static int DIRECCION_ARRIBA = 0;
	public static int DIRECCION_DERECHA = 1;
	public static int DIRECCION_ABAJO = 2;
	public static int DIRECCION_IZQUIERDA = 3;
	public static int NUM_DIRECCIONES = 4;

	// arreglo direccional
	public static int[] DESPLAZAMIENTOS_Y = { -1, 0, 1, 0 };
	public static int[] DESPLAZAMIENTOS_X = { 0, 1, 0, -1 };

	/**
	 * resolver Este metodo tiene la responsabilidad de llamar al metodo resolverRecursivo inicializando los parametros en las coordenadas de salida y llegada e inicializar la matriz de casillas
	 * visitadas.
	 */
	public void resolver() {
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 1

		/**
		 * Restablecer matriz de visitadas
		 */
		for (int i = 0; i < visitadas.length; i++)
			for (int j = 0; j < visitadas[0].length; j++)
				visitadas[i][j] = false;

		int xllegada = 0;
		int yllegada = 0;

		int xsalida = 0;
		int ysalida = 0;

		for (int i = 0; i < tablero.length; i++)
			for (int j = 0; j < tablero[0].length; j++) {
				/**
				 * Obtener casilla de salida
				 */
				if (tablero[i][j].equals(SALIDA)) {
					xsalida = j;
					ysalida = i;
				}

				/**
				 * Obtener casilla de llegada
				 */
				if (tablero[i][j].equals(LLEGADA)) {
					xllegada = j;
					yllegada = i;
				}

			}

		resolverRecursivo(xsalida, ysalida, xllegada, yllegada, "");
		// FIN CODIGO ESTUDIANTES PUNTO 1
	}

	/**
	 * resolverRecursivo Este metodo tiene la responsabilidad de hallar el camino correcto del laberinto desde la posicion xcoord, ycoord retornando X si no es posible (si ya fue visitada o es un
	 * muro) o alguna de las convenciones de direccion si es posible.
	 * 
	 * @param xcoord
	 *            coordenada x de salida
	 * @param ycoord
	 *            coordenada y de salida
	 * @param llegadax
	 *            coordenada x de llegada
	 * @param llegaday
	 *            coordenada y de llegada
	 * @param camino
	 *            camino previo (lo que lleva) hasta el momento de la invocacion
	 * @return retorna "X" si el camino es incorrecto , retorna "O" si llegó al destino.
	 * 
	 */
	private String resolverRecursivo(int xcoord, int ycoord, int llegadax, int llegaday, String camino) {

		// caso base: por fuera de la matriz
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 2
		if (xcoord < 0 || xcoord > (tablero.length - 1) || ycoord < 0 || ycoord > (tablero[0].length - 1))
			return "X";
		// FIN CODIGO ESTUDIANTES PUNTO 2

		// caso base: YA VISITADA O MARCAR VISITADA
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 3
		if (visitadas[ycoord][xcoord])
			return "X";

		visitadas[ycoord][xcoord] = true;
		// FIN CODIGO ESTUDIANTES PUNTO 3

		// caso base : si esta casilla esta llena
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 4
		if (tablero[ycoord][xcoord].equals(MURO))
			return "X";
		// FIN CODIGO ESTUDIANTES PUNTO 4

		// caso base 2: llegué
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 5
		if (tablero[ycoord][xcoord].equals(LLEGADA) && xcoord == llegadax && ycoord == llegaday)
			return "O";
		// FIN CODIGO ESTUDIANTES PUNTO 5

		// ------------------------------------------------------------------------------------------------------------------------------------
		// caso recursivo : PARA TODAS LAS DIRECCIONES
		// TODO: INICIO CODIGO ESTUDIANTES PUNTO 6
		String resultado = "";

		/**
		 * Arriba
		 */
		resultado = resolverRecursivo(xcoord, ycoord + DESPLAZAMIENTOS_Y[DIRECCION_ARRIBA], llegadax, llegaday, camino);
		if (!resultado.equals("X")) {
			tablero[ycoord][xcoord] = DIRECCIONES[DIRECCION_ARRIBA];
			return "lol";
		}

		/**
		 * Abajo
		 */
		resultado = resolverRecursivo(xcoord, ycoord + DESPLAZAMIENTOS_Y[DIRECCION_ABAJO], llegadax, llegaday, camino);
		if (!resultado.equals("X")) {
			tablero[ycoord][xcoord] = DIRECCIONES[DIRECCION_ABAJO];
			return "lol";
		}
		/**
		 * Derecha
		 */
		resultado = resolverRecursivo(xcoord + DESPLAZAMIENTOS_X[DIRECCION_DERECHA], ycoord, llegadax, llegaday, camino);
		if (!resultado.equals("X")) {
			tablero[ycoord][xcoord] = DIRECCIONES[DIRECCION_DERECHA];
			return "lol";
		}
		/**
		 * Izquierda
		 */
		resultado = resolverRecursivo(xcoord + DESPLAZAMIENTOS_X[DIRECCION_IZQUIERDA], ycoord, llegadax, llegaday, camino);
		if (!resultado.equals("X")) {
			tablero[ycoord][xcoord] = DIRECCIONES[DIRECCION_IZQUIERDA];
			return "lol";
		}
		// FIN CODIGO ESTUDIANTES PUNTO 6
		// -------------------------------------------------------------------------------------------------------------------------------------------------
		return "X";

	}

	/**
	 * salvarArchivo Este metodo tiene la responsabilidad de guardar un laberinto dado un nombre de archivo
	 * 
	 * @param nombre
	 */
	public void salvarArchivo(String nombre) {
		try {
			FileWriter outFile = new FileWriter(nombre);
			PrintWriter out = new PrintWriter(outFile);

			for (int i = 0; i < MAX; i++) {
				for (int j = 0; j < MAX; j++) {
					out.print(tablero[i][j]);
				}
				out.println("");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * cargarArchivo: Este metodo tiene la responsabilidad de cargar un tablero del laberinto dada una referencia a un archivo de texto
	 * 
	 * @param archivo
	 * @return
	 */
	public boolean cargarArchivo(File archivo) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			String linea = "";
			int i = 0;
			while ((linea = lector.readLine()) != null) {
				for (int j = 0; j < linea.length(); j++) {
					char c = linea.charAt(j);
					if (c == '2') {
						salidax = i;
						saliday = j;
					}
					if (c == '3') {
						llegadax = i;
						llegaday = j;
					}
					tablero[i][j] = (c + "");
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			return false;
		} catch (IOException e) {
			System.out.println("Error de lectura");
			return false;
		}
		System.out.println("Carga del archivo exitosa!");
		return true;
	}

	/**
	 * getTablero
	 * 
	 * @return
	 */
	public String[][] getTablero() {
		return tablero;
	}

	/**
	 * setTablero
	 * 
	 * @param tablero
	 */
	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}

}
