package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sIn = new Scanner(System.in);

		Almacen almacen = new Almacen();
		Collection<Cliente> clientes = new HashSet<Cliente>();
		clientes.add(new Cliente("jhon", "calle 44 # 54-44", 4356789));
		clientes.add(new Cliente("juan", "calle 45 # 55-45", 4356789));
		clientes.add(new Cliente("pedro", "calle 45 # 56-46", 4356789));
		almacen.setCliente(clientes);
		
		for (Cliente cliente : almacen.getCliente()) {
			System.out.println(cliente.getName());
			System.out.println(cliente.getAddress());
			System.out.println(cliente.getPhone());
		}
		
		almacen.removeAllCliente();
		
		/*
		 * Almacenes
		 */
		/*
		 * almacenes.add(new Almacen()); int id = almacenes.size() - 1; almacenes.get(id).setName("Calzado Pedro"); almacenes.get(id).setAddress("Calle 93 # 56-27 Local 23"); Empleado tmpEmpleado =
		 * new Empleado("Juan Camilo", "Calle 23 # 67-40", "12/12/1977", "SANITAS", "arp", 790000); almacenes.get(id).addEmpleado(tmpEmpleado); almacenes.add(new Almacen()); id = almacenes.size() - 1;
		 * almacenes.get(id).setName("Calzado Pedro"); almacenes.get(id).setAddress("Calle 45 # 60-02 Local 3");
		 * 
		 * System.out.println("Lista de Almacenes\n");
		 * 
		 * for (Almacen almacen : almacenes) { System.out.println("\t" + almacen.getName()); System.out.println("\t" + almacen.getAddress()); System.out.println("Lista de empleados\n"); for (Empleado
		 * empleado : almacen.getEmpleados()) { System.out.println("\t\t" + empleado.getName()); System.out.println("\t\t" + empleado.getAddress()); System.out.println("\t\t" +
		 * empleado.getDateOfBirth()); System.out.println("\t\t" + empleado.getEps()); System.out.println("\t\t" + empleado.getArp()); System.out.println("\t\t" + empleado.getSalario()); }
		 * System.out.println(); }
		 */

		/*
		 * do {
		 * 
		 * System.out.println("\nMenu de la Agenda"); System.out.println("1. Agregar Persona"); System.out.println("2. Listar Personas"); System.out.println("3. Salir"); try {
		 * 
		 * int action = sIn.nextInt();
		 * 
		 * // exit if (action == 3) { System.out.println("Bye!"); break; }
		 * 
		 * System.out.println();
		 * 
		 * switch (action) { case 1: System.out.println("Agregue los datos pertinentes a continuación\n"); System.out.println("Nombre:"); String nombre = sIn.next(); System.out.println("DNI:"); int
		 * dni = sIn.nextInt(); agenda.addPersona(nombre, dni); break;
		 * 
		 * case 2: if (!agenda.hasPersonas()) { System.out.println("No hay personas en la agenda"); continue; }
		 * 
		 * System.out.println("Listado de personas en su agenda:\n"); for (Persona persona : agenda.getPersonas()) { System.out.println("\tNombre:\t" + persona.getNombre());
		 * System.out.println("\tDNI:\t" + persona.getDni()); System.out.println(); } break;
		 * 
		 * default: System.out.println("No selecciono una opción valida"); break;
		 * 
		 * } } catch (Exception e) { System.out.println("\nOpps, ocurreio un error :!"); System.out.println("Error: " + e.getMessage()); System.out.println("Bye!"); break; }
		 * 
		 * } while (true);
		 */
		sIn.close();

	}
}
