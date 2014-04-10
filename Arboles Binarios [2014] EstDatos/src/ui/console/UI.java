package ui.console;

import kernel.binary.tree.Arbol;
import kernel.console.Action;
import kernel.console.ConsoleUI;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class UI extends ConsoleUI {

	private Arbol arbol = new Arbol();

	@Override
	protected Action[] registerCommands() {
		return new Action[] { new Agregar(this), new Preorden(this), new Inorden(this), new Postorden(this), new Buscar(this), new Altura(this), new Nodo(this), new Hoja(this), new Salir(this) };
	}

	@Override
	protected void printHeader() {
		System.out.println("Estructuras de Datos 2014-1");
		System.out.println("Jhon Jairo Eslava 1310012946\n");
		System.out.println("Operaciones con arboles binarios");
	}

	@Override
	protected void printMenu() {
		System.out.println();
		System.out.println("agregar:\t Agregar numero al arbol");
		System.out.println("preorden:\t Imprimir en preorden");
		System.out.println("inorden:\t Imprimir en inorden");
		System.out.println("postorden:\t Imprimir en postorden");
		System.out.println("buscar:\t\t Buscar numero");
		System.out.println("altura:\t\t Saber la altura del arbol");
		System.out.println("nodos:\t\t Saber el numero de nodos del arbol");
		System.out.println("hojas:\t\t Saber el numero de hojas del arbol");
		System.out.println("salir:\t\t Salir");
		System.out.println();

	}

	@Override
	protected void onError(Exception e) {
		System.out.println("\nOpps, ocurrio un error :!");
		System.out.println("Error: " + e.getMessage());
		System.out.println("Bye!");

	}

	@Override
	protected void onCommand(String command) {
		// ...
	}

	@Override
	protected void onInvalidCommand(String command) {
		System.out.println("No selecciono una opci\u00F3n valida");
	}

	public Arbol getArbol() {
		return arbol;
	}
}
