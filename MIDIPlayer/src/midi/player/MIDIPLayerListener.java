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
	public void onMIDIUnavailable(MIDIPlayerEvent e);

	public void onInvalidMIDIFile(MIDIPlayerEvent e);

	public void onFileNotFound(MIDIPlayerEvent e);

	public void onTerminate(MIDIPlayerEvent e);
}
