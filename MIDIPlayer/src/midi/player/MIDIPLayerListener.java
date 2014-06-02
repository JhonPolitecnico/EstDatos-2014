package midi.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.util.EventListener;

/**
 * Listener of player
 * 
 */
public interface MIDIPLayerListener extends EventListener {

	/**
	 * It occurs when there is no MIDI library
	 * 
	 * @param e
	 */
	public void onMIDIUnavailable(MIDIPlayerEvent e);

	/**
	 * Occurs when the song playing is invalid
	 * 
	 * @param e
	 */
	public void onInvalidMIDIFile(MIDIPlayerEvent e);

	/**
	 * It occurs when the file is missing the track
	 * 
	 * @param e
	 */
	public void onFileNotFound(MIDIPlayerEvent e);

	/**
	 * It occurs to finish playing a song
	 * 
	 * @param e
	 */
	public void onTerminate(MIDIPlayerEvent e);
}
