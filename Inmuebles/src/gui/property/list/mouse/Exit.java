package gui.property.list.mouse;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exit application
 * 
 */
public class Exit implements ActionListener {

	private gui.property.list.Controller listController;

	public Exit(gui.property.list.Controller listController) {
		super();
		this.listController = listController;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (!listController.isCurrentUser())
			this.listController.dispose();
		else
			this.listController.dispose();
	}
}
