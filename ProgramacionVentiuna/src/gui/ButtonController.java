package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventiuna
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class ButtonController implements ActionListener {

	private Frame frame;

	public ButtonController(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String sCommand = arg0.getActionCommand();

		switch (sCommand) {
		case "Carta":
			this.cartaCommand();
			break;

		case "Pasar":
			this.pasarCommand();
			break;

		default:
			break;
		}

	}

	private void cartaCommand() {
		this.frame.getModel().pedirCarta(this.frame.getModel().darTurno());
		this.frame.refrescar();
	}

	private void pasarCommand() {
		this.frame.getModel().plantar(this.frame.getModel().darTurno());
		this.frame.refrescar();
	}
}