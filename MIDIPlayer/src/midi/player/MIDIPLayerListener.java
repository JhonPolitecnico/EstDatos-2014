package midi.player;

import java.util.EventListener;

public interface MIDIPLayerListener extends EventListener {
	public void onTerminate(MIDIPlayerEvent e);
}
