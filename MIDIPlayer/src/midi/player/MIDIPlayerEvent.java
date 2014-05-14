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

/**
 * Event of player
 *
 */
public class MIDIPlayerEvent extends EventObject {

	private static final long serialVersionUID = 8322396952129914755L;
	private MIDIFile mIDIFile;

	public MIDIPlayerEvent(Object source, MIDIFile mIDIFile) {
		super(source);
		this.mIDIFile = mIDIFile;
	}

	public MIDIFile getMIDIFile() {
		return mIDIFile;
	}

}
