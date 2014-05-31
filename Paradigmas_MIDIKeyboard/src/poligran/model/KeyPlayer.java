package poligran.model;

/**
 * MIDIKeyBoard
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

import poligran.model.exceptions.KeyLoaderException;
import serializer.engine.Serializer;

public class KeyPlayer {

	private Synthesizer synth;
	private MidiChannel[] channels;
	private int channel;
	private int volume;
	private int duration;
	private HashMap<String, Integer> notes = new HashMap<String, Integer>();
	private ArrayList<NoteLog> notesLog = new ArrayList<NoteLog>();

	public void playNote(int key) {
		try {
			// --------------------------------------
			// Play a few notes.
			// The two arguments to the noteOn() method are:
			// "MIDI note number" (pitch of the note),
			// and "velocity" (i.e., volume, or intensity).
			// Each of these arguments is between 0 and 127.

			channels[channel].noteOn(key, volume);
			Thread.sleep(duration);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void playNote(String note) {
		playNote(this.notes.get(note));
		this.notesLog.add(new NoteLog(note, System.currentTimeMillis()));
	}

	public void stopNote(int note) {
		channels[channel].noteOff(60);
	}

	public void resetLog() {
		this.notesLog = new ArrayList<NoteLog>();
	}

	public KeyPlayer() throws KeyLoaderException {

		initNotes();
		channel = 0;
		volume = 80;
		duration = 1000;

		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();

			// synth.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws KeyLoaderException
	 * @param
	 * @return Description
	 * 
	 * 
	 *         TODO: Punto 3 –Cargar notas base (Lectura de archivos) [25 puntos] El método private void initNotes()throws KeyLoaderException de la clase KeyPlayer tiene la responsabilidad de
	 *         cargar un archivo de texto (keys.k) que asocia cada una de las teclas a un código MIDI que representa dicha nota. La manipulación de este archivo permite asignar directamente el
	 *         sonido a cada una de las teclas.
	 * 
	 *         Para implementar este método usted debe tener en cuenta: + La ubicación del archivo keys.k es la carpeta data del proyecto + Cada línea representa una pareja <nota>,<código> + La
	 *         clase provee un método public void setNoteValue(String note, int value) que permite cambiar la asignación de código a una nota particular (es necesario llamarlo) + Se deben manejar
	 *         las excepciones asociadas a la lectura de archivos y en caso de presentarse, se debe lanzar una excepción de tipo KeyLoaderException según las especificaciones del punto anterior.
	 * @throws KeyLoaderException
	 */
	private void initNotes() throws KeyLoaderException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("./data/keys.k")));

			String line = "";

			while (true) {

				line = br.readLine();

				if (line == null)
					break;

				String[] parts = line.split(",");
				this.setNoteValue(parts[0], Integer.parseInt(parts[1]));
			}

		} catch (IOException e) {
			throw new KeyLoaderException(e);
		}

	}

	/**
	 * @param f
	 * @param
	 * @return Description
	 * 
	 *         TODO: Punto 4 – Guardar registro de notas (escritura de archivos binarios) [25 puntos] El método public void saveLog(File f) de la clase KeyPlayer tiene como responsabilidad guardar
	 *         un registro de las notas que fueron tecleadas en una sesión junto con su tiempo (en milisegundos). La clase NoteLog guarda dicha información cada vez que el usuario presiona una tecla
	 *         del piano y este método debe guardar la colección de registros en un archivo binario. El archivo guarda primero el número de elementos (tamaño de la colección) y luego cada uno de
	 *         los objetos en forma secuencial. Tenga en cuenta que: + Debe lograr que el objeto se pueda escribir en un archivo binario, para ello implemente la interfaz correspondiente y genere un
	 *         numero serial que identifique la clase. + Utilice las clases correspondientes a la escritura de archivos binarios + Maneje las excepciones internamente, el método no lanza excepciones.
	 */
	public void saveLog(File f) {
		Serializer serializer = new Serializer(f);
		serializer.serialize(this.getNotesLog());
	}

	public void setNoteValue(String note, int value) {
		this.notes.put(note, value);
	}

	public ArrayList<NoteLog> getNotesLog() {
		return notesLog;
	}

	public void setNotesLog(ArrayList<NoteLog> notesLog) {
		this.notesLog = notesLog;
	}

}
