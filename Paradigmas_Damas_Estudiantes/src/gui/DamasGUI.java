package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Casilla;
import model.Ficha;
import model.TableroDamas;

public class DamasGUI extends JFrame 
{

	/**
	 * JPanel
	 * Represents: Contenido de la ventana principal
	 */
	private JPanel contentPane;
	/**
	 * JPanel
	 * Represents: panel principal del tablero
	 */
	private JPanel pnlMain;
	/**
	 * JMenuBar
	 * Represents: barra de menu
	 */
	private JMenuBar menuBar;
	/**
	 * JMenu
	 * Represents: menu juego
	 */
	private JMenu mnJuego;
	
	/**
	 * JMenuItem
	 * Represents: item reiniciar en el menu
	 */
	private JMenuItem mntmReiniciar;
	/**
	 * JMenuItem
	 * Represents: item salir en el menu
	 */
	private JMenuItem mntmSalir;
	
	/**
	 * TableroDamas
	 * Represents: modelo del juego
	 */
	private TableroDamas omodel;
	/**
	 * JButton[][]
	 * Represents: matriz de botones del tablero
	 */
	private JButton[][] btnBoard = new JButton[TableroDamas.MAX_TABLERO+1][TableroDamas.MAX_TABLERO+1];
	
	/**
	 * ImageIcon
	 * Represents: ruta de archivo del icono de la ficha negra
	 */
	public static ImageIcon ICON_BLACK = new ImageIcon("./img/icon_black.png");
	/**
	 * ImageIcon
	 * Represents: ruta de archivo del icono de la ficha blanca
	 */
	public static ImageIcon ICON_WHITE = new ImageIcon("./img/icon_white.png");
	/**
	 * ImageIcon
	 * Represents: ruta de archivo del icono de la ficha negra reina
	 */
	public static ImageIcon ICON_BLACK_QUEEN = new ImageIcon("./img/icon_black_queen.png");
	/**
	 * ImageIcon
	 * Represents: ruta de archivo del icono de la ficha blanca reina
	 */
	public static ImageIcon ICON_WHITE_QUEEN = new ImageIcon("./img/icon_white_queen.png");
	
	/**
	 * String
	 * Represents: comando de accion de reiniciar 
	 */
	public static String ACTION_RESTART = "RESTART";
	/**
	 * String
	 * Represents: comando de accion de salir
	 */
	public static String ACTION_EXIT = "EXIT";
	
	/**
	 * boolean
	 * Represents: false si es la primera accion (origen) de una jugada, true si es la segunda
	 */
	private boolean secondPlay = false;
	/**
	 * int
	 * Represents: coordenada fila de la primera accion de una jugada
	 */
	private int initialRow;
	/**
	 * int
	 * Represents: coordenada columna de la primera ccion de una jugada
	 */
	private int initialCol;

	/**
	 * ButtonListener
	 * Represents: escucha de botones
	 */
	private ButtonListener buttonListener = new ButtonListener(this);
	
	/**
	 * 
	 * @param
	 * @return
	 * Description: 
	 * La interfaz grÃ¡fica del juego consta de un Ãºnico menÃº â€œjuegoâ€� con las siguientes opciones:
		+	Reiniciar
		+	Salir
		El mÃ©todo private void createMenu() tiene como responsabilidad crear dicho menÃº de opciones, para lograrlo usted deberÃ¡:
		+	Instanciar los correspondientes componentes de menÃº (guÃ­ese por los atributos de la clase, allÃ­ estÃ¡n declarados)
		+	Agregar los items del menu al menu jugar
		+	Asignar el menÃº a la barra de menu de la ventana
		+	Asignar los textos de cada opciÃ³n del menu
		+	Asignar un escucha (gui.ButtonListener) a cada item del menÃº
		+	Asignar un comando de acciÃ³n a cada item del menÃº  (revise las constantes de la clase, allÃ­ hay acciones predefinidas)
	 */
	private void createMenu()
	{
		//INICIO PUNTO 1---------------------------------------------------------------------------------------------------------
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		/*
		 * Menu juego
		 */
		
		mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		/*
		 * Reiniciar
		 */
		mntmReiniciar = new JMenuItem("Reiniciar");
		mntmReiniciar.setActionCommand("Reiniciar");
		mntmReiniciar.addActionListener(new ButtonListener(this));
		mnJuego.add(mntmReiniciar);
		
		/*
		 * Salir
		 */
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setActionCommand("Salir");
		mntmSalir.addActionListener(new ButtonListener(this));
		mnJuego.add(mntmSalir);
		
		//FIN PUNTO 1---------------------------------------------------------------------------------------------------------
	}
	
	/**
	 * @param row_val
	 * @param col_val
	 * @param
	 * @return
	 * Description
	 * El mÃ©todo private void setupBoard(char row_val, int col_val) (que recibe un carÃ¡cter con la numeraciÃ³n de la primera fila y un entero con la numeraciÃ³n de la primera columna) tiene la responsabilidad de construir la vista del tablero, para lo cual usted debe:
		+	Asignar un organizador de espacio en forma de grilla (matriz) que permita que el panel del tablero de juego (pnlMain) organice sus componentes en una matriz de 9x9
		+	Instanciar y agregar al panel principal los 81 botones que se utilizan en la interfaz (usando la matriz de botones btnBoard definida en los atributos:
			-	Los botones de la primera fila tienen una numeraciÃ³n de la â€˜aâ€™ a la â€˜hâ€™ y estÃ¡n inactivos
			-	Los botones de la primera columna tienen una numeraciÃ³n del 1 al 8 y estÃ¡n inactivos
			-	El botÃ³n de la coordenada <0,0> no tiene utilidad
			-	Los botones restantes representan las 8X8 casillas del tablero: deben tener un escucha (gui.ButtonListener), un comando de acciÃ³n (por ejemplo â€œ2;2â€� que significa botÃ³n de la fila 2 columna 2)
			-	Debe definir colores de fondo apropiados (a su elecciÃ³n)

	 */
	private void setupBoard(char row_val, int col_val)
	{
		//INICIO PUNTO 2---------------------------------------------------------------------------------------------------------
		/*
		 * :)
		 */
		btnBoard[0][0] = new JButton(":)");
		btnBoard[0][0].setEnabled(false);
		
		/*
		 * Numeros
		 */
		for (int i = 1; i < btnBoard.length; i++) {
				btnBoard[i][0] = new JButton(String.valueOf(i));
				btnBoard[i][0].setEnabled(false);
		}
		
		/*
		 * Letras
		 * A = 65 (Ascci Code)
		 */
		for (int j = 1; j < btnBoard[0].length; j++) {
			char letter = (char) (64 + j);
			btnBoard[0][j] = new JButton(String.valueOf(letter));
			btnBoard[0][j].setEnabled(false);
		}	
		//FIN PUNTO 2---------------------------------------------------------------------------------------------------------
		
	}
	/**
	 * 
	 * @param
	 * @return
	 * Description
	 * El mÃ©todo refreshBoard tiene la responsabilidad de actualizar la vista del tablero (representado en la matriz de botones btnBoard) segÃºn el estado del modelo. Para hacer funcional el mÃ©todo usted debe:
		+	Solicitar al modelo una copia de la matriz de Casillas que representan el tablero
		+	Cambiar el fondo de cada botÃ³n del tablero respecto al color que reporta la el objeto casilla de cada posiciÃ³n.
		+	Revisar si en cada casilla hay una ficha. En caso de existir una ficha debe asignar el correspondiente icono Tenga en cuenta que las fichas pueden ser blancas o negras y podrÃ­an o no ser â€œreinasâ€�. En otras palabras, hay cuatro iconos posibles. (Las ubicaciones de sus archivos estÃ¡n especificadas en constantes de la clase DamasGUI). En caso de no haber ficha debe asignar nulo al Ã­cono.

	 */
	public void refreshBoard()
	{
		String turn = TableroDamas.darTextoTurno(this.omodel.darTurno());
		this.setTitle("Damas: Turno -> "+ turn);
		
		//INICIO DEL PUNTO 3-----------------------------------------------------------------------------------------------

		this.pnlMain.removeAll();
		
		/*
		 * Tablero
		 * Color false = negro, true = blanco
		 */
		ImageIcon image;
		Color color;
		Ficha ficha;
		
		Casilla[][] casillas = this.omodel.darCasillas();
		
		for (Casilla[] casillasA : this.omodel.darCasillas()) {
			for (Casilla casilla : casillasA) {
					System.out.print(casilla + " ");
			}
			System.out.println();
		}
		
		for (int i = 1; i < btnBoard.length; i++) {
			for (int j = 1; j < btnBoard[0].length; j++) {
				
				color = (casillas[i-1][j-1].darColor()) ? Color.WHITE : Color.BLACK;
				ficha = casillas[i-1][j-1].darFicha();
				
				if (ficha != null){
				image = (ficha.darColor()) ? ICON_WHITE : ICON_BLACK;
				}else
					image = null;
				
				btnBoard[i][j] = new JButton(image);
				btnBoard[i][j].setBackground(color);
				btnBoard[i][j].setActionCommand(i + ":" + j);
				btnBoard[i][j].addActionListener(new ButtonListener(this));
			}
		}
		
		pnlMain.setLayout(new GridLayout(9,9));
		
		for (JButton[] buttons : btnBoard) {
			for (JButton jButton : buttons) {
				if (jButton == null)
					continue;
				pnlMain.add(jButton);
				System.out.print(jButton.getActionCommand() + " ");
			}
			System.out.println();
		}
		
		pnlMain.revalidate();
		pnlMain.repaint();
		//INICIO DEL PUNTO 3-----------------------------------------------------------------------------------------------
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					DamasGUI frame = new DamasGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DamasGUI()
	{
		this.setTitle("Damas");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		createMenu();
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.pnlMain = new JPanel();
		this.pnlMain.setBackground(Color.DARK_GRAY);
		this.contentPane.add(this.pnlMain, BorderLayout.CENTER);
		
		
		//model setup
		this.omodel = new TableroDamas();
		
		//board setup
		
		setupBoard('A', 1);
		restartGame();
		
		this.refreshBoard();
	}


	public void restartGame()
	{
		String s1 = JOptionPane.showInputDialog(this, "Inserte el nombre del primer Jugador", "Jugador 1");
		String s2 = JOptionPane.showInputDialog(this, "Inserte el nombre del segundo Jugador", "Jugador 2");
		this.omodel.inicializarPartida(s1, s2);
	}

	public boolean isSecondPlay()
	{
		return secondPlay;
	}

	public void setSecondPlay(boolean secondPlay)
	{
		this.secondPlay = secondPlay;
	}

	public int getInitialRow()
	{
		return initialRow;
	}

	public void setInitialRow(int initialRow)
	{
		this.initialRow = initialRow;
	}

	public int getInitialCol()
	{
		return initialCol;
	}

	public void setInitialCol(int initialCol)
	{
		this.initialCol = initialCol;
	}

	public TableroDamas getOmodel()
	{
		return omodel;
	}

	public void setOmodel(TableroDamas omodel)
	{
		this.omodel = omodel;
	}

	public void exitGame()
	{
		System.exit(0);
	}

}
