package swing.jDataButton;

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
		// TODO Auto-generated constructor stub
	}

	public JDataButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public JDataButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public JDataButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public JDataButton(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
