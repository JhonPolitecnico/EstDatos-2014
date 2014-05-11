package table;

/**
 * Panini
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRender extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 8248630009366357860L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component celda = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (value instanceof Integer && column > 0) {

			Integer valor = (Integer) value;
			if (valor.intValue() == 0) {
				celda.setBackground(Color.RED);
				celda.setForeground(Color.WHITE);
			} else {
				if (valor.intValue() > 2) {
					celda.setBackground(Color.GREEN);
					celda.setForeground(Color.WHITE);
				} else if (valor.intValue() == 2) {
					celda.setBackground(Color.ORANGE);
					celda.setForeground(Color.BLACK);
				} else {
					celda.setBackground(Color.WHITE);
					celda.setForeground(Color.BLACK);
				}
			}

		} else {
			celda.setBackground(Color.WHITE);
			celda.setForeground(Color.BLACK);
		}

		return celda;

	}
}
