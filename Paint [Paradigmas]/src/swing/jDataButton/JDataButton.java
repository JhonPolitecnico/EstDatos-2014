package swing.jDataButton;

/**
 * Paint
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class JDataButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4428300163947336415L;
	private Object data;

	public JDataButton(Object data) {
		super();
		this.data = data;
	}

	public JDataButton() {
		super();
	}

	public JDataButton(Action a) {
		super(a);
	}

	public JDataButton(Icon icon) {
		super(icon);
	}

	public JDataButton(String text, Icon icon) {
		super(text, icon);
	}

	public JDataButton(String name) {
		super(name);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
