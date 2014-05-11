package gui.main;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import hashtable.Persona;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

import table.CellRender;
import utils.Utils;

public class Controller extends Main {

	private static final long serialVersionUID = 163143371781152352L;

	private Persona listaPersonas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Controller() {
		super();

		setTitle("Panini - Jhon Jairo Eslava");

		// Crear frame
		Utils.centerFrame(this);

		this.listaPersonas = new Persona();

		/**
		 * Crear una lista aleatoria
		 */
		String[] personas = { "", "Diana", "Juan", "Pedro", "Camilo", "Lucia", "Jhon", "Maria", "Guillermo" };

		for (String persona : personas) {

			if (persona.equals(""))
				continue;

			ArrayList<Integer> fichas = this.listaPersonas.insertarPersona(persona);

			for (int i = 0; i < 640; i++) {

				/**
				 * Controlar el exceso de fichas repetidas
				 * 
				 * hay un 10% de sacar 0
				 * 
				 * hay un 70% de sacar un 1
				 * 
				 * hay un 10% de sacar 2
				 * 
				 * hay un 10% de sacar desde un 1 hasta un 5
				 */
				int probabilidad = Utils.randInt(0, 9);
				int numero = 0;

				if (probabilidad >= 0 && probabilidad <= 0)
					numero = 0;
				else if (probabilidad >= 1 && probabilidad <= 1)
					numero = 2;
				else if (probabilidad >= 2 && probabilidad <= 8)
					numero = 1;
				else
					numero = Utils.randInt(1, 5);

				for (int j = 0; j < numero; j++)
					fichas.add(i);
			}
		}

		Integer[][] fichas = new Integer[640][personas.length];

		for (int i = 0; i < fichas.length; i++) {
			fichas[i][0] = i;

			Hashtable<String, Integer> repetidos = this.listaPersonas.obtenerListaDeRepetidos(i);

			for (int j = 1; j < fichas[0].length; j++) {
				fichas[i][j] = repetidos.get(personas[j]);
			}
		}

		/**
		 * Mostrar la lista
		 */
		super.table.setModel(new DefaultTableModel(fichas, personas));
		super.table.setDefaultRenderer(Object.class, new CellRender());

	}
	/*
	 * Getters & Setters
	 */
}
