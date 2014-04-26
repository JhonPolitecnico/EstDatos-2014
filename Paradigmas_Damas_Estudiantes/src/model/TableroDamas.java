package model;

public class TableroDamas {
	public static int MAX_TABLERO = 8;
	public static int TURNO_BLANCO = 1;
	public static int TURNO_NEGRO = 2;
	public static int MAX_DIRECCIONES = 4;
	public static int[] deltai = {-1,+1,+1, -1};
	public static int[] deltaj = {+1, +1,-1, -1};
	
	
	private Jugador jugador1;
	private Jugador jugador2;
	private int turno =TURNO_BLANCO;
	
	
	private Casilla[][] casillas = new Casilla[MAX_TABLERO][MAX_TABLERO];
	
	public TableroDamas()
	{
		
		char fila='A';
		boolean color = true;
		//construir casillas
		for (int i = 0; i < MAX_TABLERO; i++) 
		{
			int columna=1;
			for (int j = 0; j < MAX_TABLERO; j++) 
			{
				this.casillas[i][j] = new Casilla(fila, columna, color);
				color = !color;
				columna++;
			}
			color = !color;
			fila++;
			
		}
	}
	public void inicializarPartida(String n1, String n2)
	{
		this.jugador1 = new Jugador(true, n1);//blanco
		this.jugador2 = new Jugador (false, n2);//negro
		//asignar fichas
		Ficha[] f1 = this.jugador1 .darFichas();
		Ficha[] f2 = this.jugador2 .darFichas();
		int contadorblancas = 0;
		int contadornegras  = 0;
		//jugador 2 - negro - arriba
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < MAX_TABLERO; j++)
			{
				if(this.casillas[i][j].darColor()==false)
				{
					this.casillas[i][j] .cambiarFicha(f2[contadornegras]);
					contadornegras++;
				}
			}
		}
		
		//jugador 1 - blanco - abajo
		for(int i =5; i< 8; i++ )
		{
			for (int j = 0; j < MAX_TABLERO; j++)
			{
				if(this.casillas[i][j].darColor()==false)
				{
					Ficha f = f1[contadorblancas];
					this.casillas[i][j] .cambiarFicha(f);
					contadorblancas++;
				}
			}
		}
	}
	public int darTurno()
	{
		return this.turno;
	}
	public void cambiarTurno()
	{
		if(this.turno==1)
		{
			this.turno = 2;
		}
		else
		{
			this.turno = 1;
		}
	}
	public String toString()
	{
		String res = "   1   2   3   4   5   6   7   8\n";
		char letra = 'A';
		for (int i = 0; i < MAX_TABLERO; i++)
		{
			res+=letra+" ";
			for (int j = 0; j < MAX_TABLERO; j++)
			{
				res+=this.casillas[i][j].toString()+" ";
			}
			res+="\n";
			letra++;
		}
		return res;
	}
	public boolean jugar(int fila, int columna, int filadest, int coldest)
	{
		boolean valida = validarJugada(fila, columna, filadest, coldest);
		if(valida)
		{
			mover(fila, columna, filadest, coldest);
			this.cambiarTurno();
			return true;
		}
		return false;
	}
	public boolean jugar(char fila, int columna, char filadest, int coldest)
	{
		int i_fila = convertirFila(fila);
		int j_columna = columna -1;
		int i_fila_dest = convertirFila(filadest);
		int j_col_dest = coldest-1;
		//
		boolean valida = validarJugada(i_fila, j_columna, i_fila_dest, j_col_dest);
		if(valida)
		{
			mover(i_fila, j_columna, i_fila_dest, j_col_dest);
			this.cambiarTurno();
			return true;
		}
		return false;
	}
	private void mover(int i, int j, int ni, int nj)
	{
		Ficha origen = this.casillas[i][j].darFicha();
		Ficha destino = this.casillas[ni][nj].darFicha();
		this.casillas[i][j].cambiarFicha(destino);
		this.casillas[ni][nj].cambiarFicha(origen);
		int direccion = darDireccionMovimiento(i, j, ni, nj);
		
		if(esMovimientoDiagonalDoble(i, j, ni, nj))
		{
			int iintermedia = i+deltai[direccion];
			int jintermedia = j+deltaj[direccion];
			this.casillas[iintermedia][jintermedia].darFicha().capturar();
			this.casillas[iintermedia][jintermedia].cambiarFicha(null);
			this.cambiarTurno();
		}
		
		//promover
		if(this.turno==1 && ni == 0) //promover blanco
		{
			this.casillas[ni][nj].darFicha().promover();
		}
		if(this.turno == 2 && ni == MAX_TABLERO-1 ) //promover negro
		{
			this.casillas[ni][nj].darFicha().promover();
		}
	}
	private boolean validarJugada(int i, int j, int ni, int nj)
	{
		
		if(i < 0 || i>MAX_TABLERO || j<0 || j>MAX_TABLERO ||
				ni < 0 || ni>MAX_TABLERO || nj<0 || nj>MAX_TABLERO )
		{
			return false;
		}
		//si no hay ficha en el espacio de origen
		if(this.casillas[i][j].darFicha()==null)
		{
			return false;
		}
		//si la casilla de destino esta llena
		if(this.casillas[ni][nj].darFicha()!=null)
		{
			return false;
		}
		boolean color = this.casillas[i][j].darFicha().darColor();
		if((this.turno != TURNO_BLANCO && color == true )|| (this.turno != TURNO_NEGRO && color == false ))
		{
			return false;
		}
		boolean movimientoSimple = esMovimientoDiagonalSimple(i, j, ni, nj);
		boolean movimientoDoble = esMovimientoDiagonalDoble(i, j, ni, nj);
		int direccion = darDireccionMovimiento(i, j, ni, nj);
		boolean promovida = this.casillas[i][j].darFicha().darPromovida();
		if(movimientoSimple) //caso 1: movimiento normal, solo hacia adelante
		{
			if(this.casillas[i][j].darFicha().darColor()) //caso 1.1: si la ficha es blanca, movimiento arriba (a menos que este promovida)
			{
				if(!promovida) //debe moverse hacia arriba
				{
					if(esMovimientoArriba(i, j, ni, nj))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return true;
				}
			}
			else //caso 1.2: si la ficha es negra, movimiento abajo
			{
				if(!promovida)
				{
					if(esMovimientoAbajo(i, j, ni, nj))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return true;
				}
			}
		}
		else if (movimientoDoble) //caso 2: movimiento ataque, hacia adelante con una pieza contraria en medio
		{
			if(this.casillas[i][j].darFicha().darColor()) //caso 2.1: si la ficha es blanca, movimiento arriba con una pieza contraria en medio
			{
				if(!promovida)
				{
					if(!esMovimientoArriba(i, j, ni, nj))
					{
						return false;
					}
				}
				int iintermedia = i+deltai[direccion];
				int jintermedia = j+deltaj[direccion];
				if(this.casillas[iintermedia][jintermedia].darFicha()!= null  && this.casillas[iintermedia][jintermedia].darFicha().darColor()==false )
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else //caso 2.2: si la ficha es negra, movimiento abajo con una pieza contraria en medio
			{
				if(!promovida)
				{
					if(!esMovimientoAbajo(i, j, ni, nj))
					{
						return false;
					}
				}
				int iintermedia = i+deltai[direccion];
				int jintermedia = j+deltaj[direccion];
				if(this.casillas[iintermedia][jintermedia].darFicha()!= null  && this.casillas[iintermedia][jintermedia].darFicha().darColor()==true )
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
		
	}
	private boolean esMovimientoDiagonalSimple(int i, int j, int ni, int nj)
	{
		for(int d = 0; d<MAX_DIRECCIONES; d++)
		{
			if(i+deltai[d]==ni && j+deltaj[d]==nj)
			{
				return true;
			}
		}
		return false;
	}
	private boolean esMovimientoDiagonalDoble(int i, int j, int ni, int nj)
	{
		for(int d = 0; d<MAX_DIRECCIONES; d++)
		{
			if(i+(2*deltai[d])==ni && j+(2*deltaj[d])==nj)
			{
				return true;
			}
		}
		return false;
	}
	private boolean esMovimientoArriba(int i, int j, int ni, int nj)
	{
		if(i >ni)
		{
			return true;
		}
		return false;
	}
	private boolean esMovimientoAbajo(int i, int j, int ni, int nj)
	{
		if(!esMovimientoArriba(i, j, ni, nj))
		{
			return true;
		}
		return false;
	}
	private boolean esMovimientoDerecha(int i, int j, int ni, int nj)
	{
		if(j <nj)
		{
			return true;
		}
		return false;
	}
	private boolean esMovimientoIzquierda(int i, int j, int ni, int nj)
	{
		if(!esMovimientoDerecha(i, j, ni, nj))
		{
			return true;
		}
		return false;
	}
	private int darDireccionMovimiento(int i, int j, int ni, int nj)
	{
		if(esMovimientoArriba(i, j, ni, nj))
		{
			if(esMovimientoDerecha(i, j, ni, nj))
			{
				return 0;
			}
			else
			{
				return 3;
			}
		}
		else
		{
			if(esMovimientoDerecha(i, j, ni, nj))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
	}
	private static int convertirFila(char fila)
	{
		String con = fila+"";
		con = con.toUpperCase();
		fila = con.charAt(0);
		
		int fila_num=0;
		
		for(char i='A'; i<='H';i++ )
		{
			if(fila==i)
			{
				return fila_num;
			}
			fila_num++;
		}
		return 0;
	}
	public  Casilla[][] darCasillas()
	{
		return this.casillas;
	}
	public static String darTextoTurno(int turnoActual)
	{
		if(turnoActual==TURNO_BLANCO)
		{
			return "Blanco";
		}
		return "Negro";
	}

}
