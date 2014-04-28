package midi.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.util.EventObject;

import midi.MIDIFile;

public class MIDIPlayerEvent extends EventObject {

	private static final long serialVersionUID = 8322396952129914755L;
	private MIDIFile archivo;

	public MIDIPlayerEvent(Object source, MIDIFile archivo) {
		super(source);
		this.archivo = archivo;
	}

	public MIDIFile getArchivo() {
		return archivo;
	}

}
