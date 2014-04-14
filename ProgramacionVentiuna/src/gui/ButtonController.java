package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import poligran.MainVentiuna;

/**
 * Ventiuna
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class ButtonController implements ActionListener {

	private Frame frame;
	private MainVentiuna model;

	public ButtonController(Frame frame) {
		this.frame = frame;
		this.model = this.frame.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!(e.getSource() instanceof JButton))
			return;

		JButton button = (JButton) e.getSource();

		if (!button.isEnabled())
			return;

		String sCommand = e.getActionCommand();

		switch (sCommand) {
		case "Carta":
			this.cartaCommand();
			break;

		case "Pasar":
			this.pasarCommand();
			break;

		case "Reiniciar":
			this.reiniciarCommand();
			break;

		default:
			break;
		}

	}

	private void cartaCommand() {
		this.model.pedirCarta(this.model.darTurno());
		this.frame.refrescar();
	}

	private void pasarCommand() {
		this.model.plantar(this.model.darTurno());
		this.frame.refrescar();
		// Fin del juego
		if (this.model.darPartidaTerminada()) {
			this.model.clearLog();
			this.model.plantar(this.model.darTurno());
			this.frame.setStatus(this.model.getLog());
		}
	}

	private void reiniciarCommand() {
		this.model.reiniciar();
		this.frame.refrescar();
		this.frame.setStatus("");
	}
}
