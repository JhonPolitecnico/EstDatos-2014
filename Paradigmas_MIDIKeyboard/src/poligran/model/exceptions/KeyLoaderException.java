package poligran.model.exceptions;

/**
 * MIDIKeyBoard
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.IOException;

/**
 * @author DanielSan poligran.model.exceptions KeyLoaderException.java
 * 
 *         TODO: Punto 2 –Definir excepción de carga de notas (Excepciones) [25 puntos] Se definió una excepción de modelo asociada con la carga de las notas base. Esta excepción, tiene que
 *         guardar no solamente el mensaje de error, sino además el nombre de la clase y el nombre del método donde fue generada. Para ello usted debe definir una excepción (KeyLoaderException) que
 *         tenga dichos datos.
 */
public class KeyLoaderException extends Exception {

	private static final long serialVersionUID = -4066786847021503749L;

	private IOException e;

	public KeyLoaderException(IOException e) {
		this.e = e;
	}

	public IOException getE() {
		return this.e;
	}

}
