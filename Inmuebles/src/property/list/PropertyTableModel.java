package property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import property.Property;
import property.list.cell.Controller;

/**
 * A model that contains a list of properties
 * 
 * @param <T>
 *            property of type "Property"
 */
public class PropertyTableModel extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = -3369331427406130133L;

	private JTable owner;
	private ArrayList<Property> properties;

	public PropertyTableModel(JTable owner) {
		super();
		this.owner = owner;
		properties = new ArrayList<Property>();

		/**
		 * Prepare JTable
		 */
		this.owner.setDefaultRenderer(Object.class, new PropertyCellRender());
		this.owner.setRowHeight((new Controller()).getSize().height);
		this.owner.setTableHeader(null);
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return this.properties.size();
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (rowIndex > this.properties.size() - 1)
			return null;

		Property property = this.properties.get(rowIndex);

		if (property == null)
			return null;

		switch (columnIndex) {
		case 0:

			return new Controller(property.getPhoto());

			// return property.getAddress();

		default:
			return null;
		}

	}

	/**
	 * Remove all rows
	 * 
	 */
	public void clear() {
		int rowCount = this.getRowCount();
		this.properties.clear();

		/**
		 * Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been deleted.
		 */
		super.fireTableRowsDeleted(rowCount, rowCount);
	}

	/**
	 * Add row from a Property
	 * 
	 * @param Property
	 */
	public void addRow(Property property) {
		int rowCount = this.getRowCount();
		this.properties.add(property);

		/**
		 * Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been inserted.
		 */
		super.fireTableRowsInserted(rowCount, rowCount);
	}

	/**
	 * Remove a row
	 * 
	 * @param row
	 */
	public void removeRow(int row) {
		int rowCount = this.getRowCount();

		this.properties.remove(row);

		/**
		 * Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been deleted.
		 */
		super.fireTableRowsDeleted(rowCount, rowCount);
	}

	/**
	 * Get reference to $row
	 * 
	 * @param row
	 * @return
	 */
	public Property getRow(int row) {
		return this.properties.get(row);
	}

	/**
	 * Notifies that a row was updated
	 * 
	 * @param row
	 */
	public void updateRow(int row) {
		/**
		 * Notifies all listeners that rows in the range [firstRow, lastRow], inclusive, have been updated.
		 */
		super.fireTableRowsUpdated(row, row);
	}

	/**
	 * Return clone
	 * 
	 */
	public PropertyTableModel clone() {
		PropertyTableModel clon = new PropertyTableModel(this.owner);

		for (Property property : this.properties)
			clon.addRow(property);

		return clon;
	}
}
