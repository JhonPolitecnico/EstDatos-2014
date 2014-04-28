package gui.main.player;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
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
		this.player.playAndPause();
	}

	public void onTerminate(MIDIPlayerEvent e) {
		id++;

		System.out.println(controller.getMIDIList().size());
		System.out.println(id);
		if (id >= controller.getMIDIList().size()) {
			this.reset();
			if (!isRepeat()) {
				this.stop();
				return;
			}
		}

		this.newPlayer(controller.getMIDIList().get(id).getArchivo());
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
		this.newPlayer(controller.getMIDIList().get(id).getArchivo());
	}

}
