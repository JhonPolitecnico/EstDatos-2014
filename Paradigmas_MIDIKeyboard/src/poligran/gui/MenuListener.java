package poligran.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener
{
	public static final String MENU_SHOW = "SHOW";
	public static final String MENU_SAVE = "SAVE";
	public static final String MENU_RESET = "RESET";
	private KeyboardFrame parent;
	public MenuListener(KeyboardFrame keyboardFrame)
	{
		this.parent = keyboardFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String command = arg0.getActionCommand();
		if(command .equals(MENU_SHOW))
		{
			this.parent.showLog();
		}
		else if (command.equals(MENU_SAVE))
		{
			this.parent.saveLog();
		}
		else if(command.equals(MENU_RESET))
		{
			this.parent.resetLog();
		}

	}

}
