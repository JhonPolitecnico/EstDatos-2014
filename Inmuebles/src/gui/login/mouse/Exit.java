package gui.login.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Exit application
 * 
 */
public class Exit extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}
}
