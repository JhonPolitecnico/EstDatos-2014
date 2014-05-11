package jpng.file;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import graphic.Brush;

import java.io.Serializable;
import java.util.ArrayList;

public class JpngFile implements Serializable {

	private static final long serialVersionUID = -951426532202463347L;

	private ArrayList<Brush> brushes;

	public JpngFile(ArrayList<Brush> brushes) {
		super();
		this.brushes = brushes;
	}

	public ArrayList<Brush> getBrushes() {
		return brushes;
	}

}
