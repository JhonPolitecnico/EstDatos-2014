package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author DanielSantamaria gui ButtonListener.java La clase ButtonListener
 *         tiene la responsabilidad de responder a los eventos generados por los
 *         botones del tablero de la interfaz gráfica. Para ello debe
 *         implementar la interfaz correspondiente a los escuchas de botones.
 *         Para implementar este punto usted debe completar la implementación
 *         de la clase ButtonListener de la siguiente manera: + Debe implementar
 *         la interfaz correspondiente y los métodos que corresponden a dicha
 *         interfaz. + Debe implementar la funcionalidad del método de acción
 *         según el comando de acción enviado como parámetro: - Si la acción
 *         corresponde a acciones del menú (reiniciar, salir) llamar a los
 *         métodos de DamasGUI que cumplen dichas responsabilidades. Si la
 *         acción es reiniciar, se deben llamar los métodos restartGame()y
 *         refreshBoard() y si es salir se debe llamar al método exitGame(). -
 *         Si la acción corresponde a un botón del tablero, debe tratar de
 *         jugar. Tenga en cuenta que una jugada tiene dos acciones, una casilla
 *         origen y una casilla destino: En caso de ser la primera acción,
 *         deberá 1. guardar la coordenada de origen mediante los métodos
 *         public void setInitialRow(int initialRow) y public void
 *         setInitialCol(int initialCol), 2. Indicar que la siguiente será la
 *         acción 2 mediante llamado al método public void
 *         setSecondPlay(boolean secondPlay) En caso de ser la segunda acción,
 *         deberá 1. Guardar la coordenada de destino localmente, invocar al
 *         método public boolean jugar(int fila, int columna, int filadest, int
 *         coldest) del modelo (que devuelve true si la jugada fue valida) y en
 *         caso que la jugada sea invalida mostrar un mensaje al usuario. Se
 *         debe llamar al método refreshBoard() que actualiza la vista del
 *         tablero
 * 
 * 
 */
public class ButtonListener implements ActionListener {
	private DamasGUI parent;

	public ButtonListener(DamasGUI pa) {
		this.parent = pa;
	}

	// INICIO DEL PUNTO
	// 4----------------------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		/*
		 * Menu Actions
		 */

		if (command.equals("Reiniciar")) {
			parent.restartGame();
			parent.refreshBoard();
			return;
		}

		if (command.equals("Salir")) {
			parent.exitGame();
			return;
		}

		/*
		 * Casillas
		 */

		String[] parts = command.split(":", 2);

		int x = Integer.parseInt(parts[0]);
		int y = Integer.parseInt(parts[1]);

		// Primer paso
		if (!parent.isSecondPlay()) {
			parent.setInitialRow(x - 1);
			parent.setInitialCol(y - 1);
			parent.setSecondPlay(true);
		} else {
			if (parent.getOmodel().jugar(parent.getInitialRow(),
					parent.getInitialCol(), x - 1, y - 1)) {
				parent.refreshBoard();
			} else {
				System.out.println("no podes mover hay ...");
			}
			parent.setSecondPlay(false);
		}

	}

	// FIN DEL PUNTO
	// 4-------------------------------------------------------------------------------------------------------------------------

}
