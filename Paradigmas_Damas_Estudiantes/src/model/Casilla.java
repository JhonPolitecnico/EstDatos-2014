package model;

public class Casilla {

	private boolean color = false;
	private char fila = 'A';
	private int columna = 1;
	private Ficha ficha ;
	public Casilla(char fila, int columna, boolean color) 
	{
		this.color = color;
		this.fila = fila;
		this.columna = columna ;
	}
	public boolean darColor()
	{
		return this.color;
	}
	public void cambiarFicha(Ficha f)
	{
		this.ficha = f;
	}
	public Ficha darFicha()
	{
		return this.ficha;
	}
	public String toString()
	{
		String res = "";
		if(this.ficha==null)
		{
			if(this.color)
			{
				res+=" ";
			}
			else
			{
				res+="░";
			}
		}
		else
		{
			res+=this.ficha.toString();
			
		}
		return "["+res+"]";
		
	}

}
