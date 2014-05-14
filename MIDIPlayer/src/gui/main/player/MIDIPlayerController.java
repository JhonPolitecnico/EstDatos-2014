package gui.main.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JOptionPane;

import gui.main.Controller;
import midi.MIDIFile;
import midi.player.MIDIPLayerListener;
import midi.player.MIDIPlayer;
import midi.player.MIDIPlayerEvent;

public class MIDIPlayerController implements MIDIPLayerListener {

	private Controller controller;
	private MIDIPlayer player;
	private int id;
	private boolean repeat;

	public MIDIPlayerController(Controller controller) {
		super();
		this.controller = controller;
		this.id = 0;
		repeat = false;
	}

	private void newPlayer(MIDIFile archivo) {
		this.player = new MIDIPlayer(archivo);
		this.player.setEventListener(this);
		if (this.player.prepare())
			this.player.playAndPause();
	}

	@Override
	public void onTerminate(MIDIPlayerEvent e) {
		id++;

		if (id >= controller.getMIDIList().size()) {
			this.reset();

			/**
			 * Repeat at the end of the playlist
			 */
			if (!isRepeat())
				return;
		}

		this.newPlayer(controller.getMIDIList().get(id).getMIDIFile());
	}

	@Override
	public void onMIDIUnavailable(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, usted no tiene una libreria MIDI compatible", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onInvalidMIDIFile(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, el archivo que intenta reproducir no es un archivo MIDI compatible o esta corrupto", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onFileNotFound(MIDIPlayerEvent e) {
		this.reset();
		JOptionPane.showMessageDialog(this.controller, "Oops, el archivo que intenta reproducir no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void reset() {
		this.id = 0;
		this.stop();
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	public MIDIPlayer getPlayer() {
		return player;
	}

	public void playAndPause() {
		this.player.playAndPause();
	}

	public void stop() {
		this.player.stop();
		this.player = null;
	}

	public boolean isPlaying() {
		return (this.player != null);
	}

	public void playCurrent() {
		this.newPlayer(controller.getMIDIList().get(id).getMIDIFile());
	}

}
