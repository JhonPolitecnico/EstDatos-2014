package midi.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import midi.MIDIFile;


/**
 * The real, crude and basic player
 *
 */
public class MIDIPlayer implements MetaEventListener {

	public static final int END_OF_TRACK_MESSAGE = 47;

	private Sequence mySeq;
	private Sequencer sequencer;
	private boolean started = false;
	private MIDIFile mIDIFile;
	private MIDIPLayerListener listener;

	public MIDIPlayer(MIDIFile mIDIFile) {
		this.mIDIFile = mIDIFile;
	}

	public boolean prepare() {
		FileInputStream is = null;
		try {
			sequencer = MidiSystem.getSequencer();
			if (sequencer == null)
				throw new MidiUnavailableException();
			sequencer.open();
			is = new FileInputStream(this.mIDIFile.getFile());
			mySeq = MidiSystem.getSequence(is);
			sequencer.setSequence(mySeq);
			sequencer.addMetaEventListener(this);

		} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {

			/**
			 * Close if open
			 */
			if (is != null)
				try {
					is.close();
				} catch (IOException e1) {
					// None here...
				}

			/**
			 * Raises an error event
			 */
			if (this.listener != null) {
				MIDIPlayerEvent mE = new MIDIPlayerEvent(this, this.mIDIFile);

				if (e instanceof MidiUnavailableException)
					this.listener.onMIDIUnavailable(mE);

				if (e instanceof InvalidMidiDataException)
					this.listener.onInvalidMIDIFile(mE);

				if (e instanceof IOException)
					this.listener.onFileNotFound(mE);
			}

			return false;
		}
		return true;
	}

	public long getMicrosecondTime() {
		return this.sequencer.getMicrosecondLength();
	}

	/**
	 * Set the listener
	 * 
	 * @param listener
	 */
	public void setEventListener(MIDIPLayerListener listener) {
		this.listener = listener;
	}

	public void playAndPause() {
		if (sequencer != null)
			if (!started) {
				sequencer.start();
				started = true;
			} else {
				sequencer.stop();
				started = false;
			}

	}

	public void stop() {
		if (sequencer != null)
			sequencer.stop();
		started = false;
	}

	/**
	 * Raises an event to finish playing the song
	 */
	public void meta(MetaMessage e) {
		if (e.getType() == END_OF_TRACK_MESSAGE) {
			if (listener != null) {
				MIDIPlayerEvent mE = new MIDIPlayerEvent(this, this.mIDIFile);
				listener.onTerminate(mE);
			}
		}
	}
}
