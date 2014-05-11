package hashtable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

public class Persona extends Hashtable<String, ArrayList<Integer>> {

	private static final long serialVersionUID = 4082462919985308422L;

	public ArrayList<Integer> insertarPersona(String nombre) {
		super.put(nombre, new ArrayList<Integer>());
		return this.buscarPersona(nombre);
	}

	public ArrayList<Integer> insertarPersona(String nombre, ArrayList<Integer> fichas) {
		super.put(nombre, fichas);
		return this.buscarPersona(nombre);
	}

	/**
	 * Busca una persona y devuelve sus fichas en caso de existir
	 * 
	 * @param nombre
	 * @return
	 */
	public ArrayList<Integer> buscarPersona(String nombre) {
		return (super.containsKey(nombre)) ? super.get(nombre) : null;
	}

	/**
	 * Obtiene una lista de las personas con el numero de veces que tienen la ficha indicada
	 * 
	 * @param ficha
	 * @return
	 */
	public Hashtable<String, Integer> obtenerListaDeRepetidos(int ficha) {

		Hashtable<String, Integer> repetidos = new Hashtable<String, Integer>();

		for (Entry<String, ArrayList<Integer>> entry : super.entrySet()) {
			String nombre = entry.getKey();
			ArrayList<Integer> fichas = entry.getValue();

			int veces = 0;

			for (Integer integer : fichas)
				if (integer == ficha)
					veces++;

			repetidos.put(nombre, veces);
		}

		return repetidos;

	}

}
