package console;
import java.util.Scanner;

import model.TableroDamas;


public class DamasUI 
{
	private static final int MAX_OPCIONES = 3;
	private TableroDamas tablero = new TableroDamas();
	public static void main(String[] args) 
	{
		DamasUI d = new DamasUI();
		d.menu();
		
	}
	public void menu()
	{
		Scanner teclado = new Scanner(System.in);
		System.out.println("Damas");
		
		int opcion =0;
		reiniciar();
		while(opcion != MAX_OPCIONES)
		{
			
			imprimirTablero();
			
			System.out.println("Ingrese opcion");
			System.out.println("1. Reiniciar");
			System.out.println("2. Jugar");
			System.out.println("3. Salir");
			opcion = teclado.nextInt();
			if(opcion == 1)
			{
				reiniciar();
			}
			else if(opcion == 2)
			{
				jugar();
			}
			else if(opcion == 3)
			{
				System.out.println("Salir !!!");
			}
		}
	}
	private void reiniciar()
	{
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese nickname jugador 1");
		String n1 = teclado.nextLine();
		System.out.println("Ingrese nickname jugador 2");
		String n2 = teclado.nextLine();
		this.tablero = new TableroDamas();
		this.tablero.inicializarPartida(n1, n2);
		
	}
	private void jugar() 
	{
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese fila origen(A-H)");
		char fila = teclado.next().charAt(0);
		System.out.println("Ingrese columna origen (1-8)");
		int columna = teclado.nextInt();
		System.out.println("Ingrese fila origen(A-H)");
		char filan = teclado.next().charAt(0);
		System.out.println("Ingrese columna origen (1-8)");
		int columnan = teclado.nextInt();
		boolean res = this.tablero.jugar(fila, columna, filan, columnan);
		if(!res)
		{
			System.out.println("Jugada Erronea!!");
		}
			
		
	}
	private  void imprimirTablero() 
	{
		int turno = this.tablero.darTurno();
		if(turno == TableroDamas.TURNO_BLANCO)
		{
			System.out.println("Turno: Blanco");
		}
		else
		{
			System.out.println("Turno: Negro");
		}
		
		System.out.println(this.tablero);
		
	}
}
