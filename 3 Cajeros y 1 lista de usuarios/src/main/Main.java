package main;

import cola.Cola;
import lista.Lista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lista cajeros = new Lista();
		Cola usuarios = new Cola();

		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());

		Cajero cajero = (Cajero) cajeros.getItem(4);
		cajero.agregarUsuario((Usuario) usuarios.dequeue());
	}

}
