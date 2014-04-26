package model;

public class Ficha 
{
	private boolean color ;
	private boolean capturada = false;
	private boolean promovida = false;
	
	public Ficha (boolean color)
	{
		this.color=color;
	}
	public boolean darColor()
	{
		return this.color;
	}
	public boolean darCapturada()
	{
		return this.capturada;
	}
	public boolean darPromovida()
	{
		return this.promovida;
	}
	public void capturar()
	{
		this.capturada = true;
	}
	public void promover()
	{
		this.promovida = true;
	}
	public String toString()
	{
		String res = "";
		if(darPromovida())
		{
			if(darColor())
			{
				//blanca promovida
				res+="B";
			}
			else
			{
				//negra promovida
				res+="N";
			}
		}
		else
		{
			if(darColor())
			{
				//blanca normal
				res+="b";
			}
			else
			{
				//negra normal
				res+="n";
			}
		}
		return res;
	}
	
}
