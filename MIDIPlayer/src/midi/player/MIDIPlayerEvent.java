package midi.player;

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
