package midi.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.util.EventListener;

public interface MIDIPLayerListener extends EventListener {
	public void onTerminate(MIDIPlayerEvent e);
}
