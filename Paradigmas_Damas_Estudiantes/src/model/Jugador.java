package model;

public class Jugador 
{
	private boolean color = false;
	private String nickname = "";
	
	public static int MAX_FICHAS = 12;
	private Ficha [] fichas = new Ficha[MAX_FICHAS];
	public Jugador(boolean color, String nickname)
	{
		this.nickname = nickname;
		//construir fichas
		this.color = color;
		for (int i = 0; i < MAX_FICHAS; i++) 
		{
			this.fichas[i] = new Ficha(color);
		}
	}
	public Ficha[] darFichas()
	{
		return this.fichas;
	}
}
