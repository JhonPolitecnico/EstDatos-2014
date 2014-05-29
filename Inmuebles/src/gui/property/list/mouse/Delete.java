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
 * Remove multiple properties selected
 * 
 */
public class Delete implements ActionListener {

	private gui.property.list.Controller listController;

	public Delete(gui.property.list.Controller listController) {
		super();
		this.listController = listController;
	}

	public void actionPerformed(ActionEvent e) {

		int rows[] = this.listController.getTable().getSelectedRows();

		for (int i = 0; i < rows.length; i++) {
			this.listController.getPropertyTable().removeRow(rows[i] - i);
		}
	}

}
