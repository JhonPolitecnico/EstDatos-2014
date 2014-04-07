package ui.console;

import kernel.binary.tree.Arbol;
import kernel.console.ConsoleUI;

public class UI extends ConsoleUI {

	Arbol arbol = new Arbol();

	@Override
	protected String[] registerCommands() {
		return new String[] { "agregar", "preorden", "inorden", "postorden", "buscar", "altura", "nodos", "hojas", "salir" };
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

	/*
	 * Actions
	 */

	public void agregarAction() {
		System.out.println("Escribe el numero a agregar:");

		if (this.in.hasNextInt()) {
			boolean ret = this.arbol.addNode(this.in.nextInt());
			if (ret)
				System.out.println("Numero agregado!");
			else
				System.out.println("El numero no se pudo agregar :'c");
		} else {
			System.out.println("El numero es invalido");
			this.skipError();
		}
	}

	public void preordenAction() {
		System.out.println("Preorden: " + this.arbol.preorden());
	}

	public void inordenAction() {
		System.out.println("Inorden: " + this.arbol.inorden());
	}

	public void postordenAction() {
		System.out.println("Postorden: " + this.arbol.postorden());
	}

	public void buscarAction() {
		System.out.println("Escribe el numero a buscar:");

		if (this.in.hasNextInt()) {
			boolean ret = this.arbol.search(this.in.nextInt());
			if (ret)
				System.out.println("Numero encontrado!");
			else
				System.out.println("El numero no existe :'c");
		} else {
			System.out.println("El numero es invalido");
			this.skipError();
		}
	}

	public void loginAction() {
		System.out.println("Escribe tu nombre:");
		if (this.in.hasNext())
			System.out.println("Tu nombre es: " + this.in.next());

		System.out.println("Escribe tu ID:");
		if (this.in.hasNextInt())
			System.out.println("Tu ID es: " + this.in.nextInt());
		else {
			System.out.println("Tu ID es invalido");
			this.skipError();
		}

	}

	public void alturaAction() {
		System.out.println("La altura del arbol es: " + this.arbol.getHigh());
	}

	public void nodosAction() {
		System.out.println("El numero de nodos del arbol es: " + this.arbol.getNumberOfNodes());
	}

	public void hojasAction() {
		System.out.println("El numero de hojas del arbol es: " + this.arbol.getNumberOfLeaves());
	}

	public void salirAction() {
		System.out.println("Bye!");
		this.off();
	}

}
