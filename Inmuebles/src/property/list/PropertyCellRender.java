package property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PropertyCellRender extends DefaultTableCellRenderer {

	private static final long serialVersionUID = -2679257635332158017L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		if (!(value instanceof Component))
			return null;

		if (isSelected)
			((Component) value).setBackground(new Color(205, 235, 139));

		return (Component) value;
	}
}
