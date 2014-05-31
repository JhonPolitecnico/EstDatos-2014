package poligran.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

/**
 * @author DanielSan poligran.gui PianoKeyboardListener.java TODO: PUNTO 1: Implementar la clase PianoKeyboardListener. Las teclas del piano estÃ¡n definidas como variables de tipo JLabel, razÃ³n por
 *         la cual no pueden responder a eventos de acciÃ³n (ActionEvent) , razÃ³n por la cual se requiere que las teclas funcionen mediante eventos asociados con el mouse. Para el desarrollo de este
 *         punto usted debe: + Implementar la interfaz de evento que considere necesaria para atender los eventos de las teclas del piano en la clase PianoKeyboardListener + Implementar los mÃ©todos
 *         que son necesarios para la interfaz que usted seleccionÃ³ + Dependiendo del valor de la tecla oprimida, se deberÃ¡ llamar al mÃ©todo playNote de la clase KeyboardFrame Nota: El mÃ©todo xx
 *         recibe como parametro un string con la nota a tocar que puede ser â€œCâ€�, â€œC#â€�, â€œDâ€�, â€œD#â€�, â€œEâ€�, â€œFâ€�, â€œF#â€�, â€œGâ€�, â€œG#â€�, â€œAâ€�, â€œA#â€�, â€œBâ€� (do, do
 *         sostenido, re, re sostenido, mi, fa, fa sostenido, sol, sol sostenido, la, la sostenido, si respectivamente).
 * 
 * 
 */
public class PianoKeyboardListener extends MouseAdapter {

	private KeyboardFrame keyFrame;

	public PianoKeyboardListener(KeyboardFrame keyFrame) {
		this.keyFrame = keyFrame;
	}

	@Override
	public void mouseClicked(MouseEvent me) {

		if (!(me.getSource() instanceof JLabel))
			return;

		JLabel key = (JLabel) me.getSource();

		String note = "";

		if (key == this.keyFrame.getBtnA())
			note = "A";
		else if (key == this.keyFrame.getBtnA())
			note = "A";
		else if (key == this.keyFrame.getBtnA_())
			note = "A#";
		else if (key == this.keyFrame.getBtnB())
			note = "B";
		else if (key == this.keyFrame.getBtnC())
			note = "C";
		else if (key == this.keyFrame.getBtnC_())
			note = "C#";
		else if (key == this.keyFrame.getBtnD())
			note = "D";
		else if (key == this.keyFrame.getBtnD_())
			note = "D#";
		else if (key == this.keyFrame.getBtnE())
			note = "E";
		else if (key == this.keyFrame.getBtnF())
			note = "F";
		else if (key == this.keyFrame.getBtnF_())
			note = "F#";
		else if (key == this.keyFrame.getBtnG())
			note = "G";
		else if (key == this.keyFrame.getBtnG_())
			note = "G#";

		this.keyFrame.playNote(note);
	}
}
