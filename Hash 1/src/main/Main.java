package main;

import hashtable.Capital;
import hashtable.Estudiante;

public class Main {

	public static void main(String[] args) {
		Capital capitales = new Capital();

		// Insertar
		capitales.insertarPareja("Colombia", "Bogota");
		capitales.insertarPareja("Venezuela", "Caracas");
		capitales.insertarPareja("Uruguay", "Montevideo");
		capitales.insertarPareja("Ucrania", "Kiev");

		// Bogota
		System.out.println(capitales.buscarPorClave("Colombia"));
		// Eliminar
		capitales.removerPorClave("Colombia");
		// Null
		System.out.println(capitales.buscarPorClave("Colombia"));
		// Caracas, Montevideo, Kiev
		System.out.println(capitales.devolverParejas());

		/*
		 * Estudiantes
		 */
		Estudiante estudiantes = new Estudiante();

		// Insertar
		estudiantes.insertarEstudiante(12, "jhon");
		estudiantes.insertarEstudiante(16, "juan");
		estudiantes.insertarEstudiante(31, "pedro");

		// jhon
		System.out.println(estudiantes.buscarPorCodigo(12));
		// Eliminar
		estudiantes.removerPorCodigo(12);
		// Null
		System.out.println(estudiantes.buscarPorCodigo(12));
		// pedro, juan
		System.out.println(estudiantes.devolverEstudiantes());

	}

}
