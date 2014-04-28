package midi.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.FileInputStream;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import midi.MIDIFile;

public class MIDIPlayer implements MetaEventListener {

	public static final int END_OF_TRACK_MESSAGE = 47;

	private Sequence mySeq;
	private Sequencer sequencer;
	private boolean started = false;
	private MIDIFile archivo;
	private MIDIPLayerListener listener;

	public MIDIPlayer(MIDIFile archivo) {
		try {
			this.archivo = archivo;
			sequencer = MidiSystem.getSequencer();
			if (sequencer == null)
				throw new MidiUnavailableException();
			sequencer.open();
			FileInputStream is = new FileInputStream(archivo);
			mySeq = MidiSystem.getSequence(is);
			sequencer.setSequence(mySeq);
			sequencer.addMetaEventListener(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long getMicrosecondTime() {
		return this.sequencer.getMicrosecondLength();
	}

	public void setEventListener(MIDIPLayerListener listener) {
		this.listener = listener;
	}

	public void playAndPause() {
		if (!started) {
			sequencer.start();
			started = true;
		} else {
			sequencer.stop();
			started = false;
		}

	}

	public void stop() {
		sequencer.stop();
		started = false;
	}

	public void meta(MetaMessage e) {
		if (e.getType() == END_OF_TRACK_MESSAGE) {
			MIDIPlayerEvent mE = new MIDIPlayerEvent(this, archivo);
			listener.onTerminate(mE);
		}
	}
}
