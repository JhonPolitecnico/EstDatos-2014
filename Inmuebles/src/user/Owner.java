package user;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.mask.Flag;

import java.io.Serializable;
import java.util.ArrayList;

import property.Property;

public class Owner extends User implements Rol, Serializable {

	private static final long serialVersionUID = 1619644617358068770L;

	private ArrayList<Property> properties;

	public Owner(String name, String surname, int phone, int cellphone, int dni, String nick, String password, String email) {
		super(name, surname, phone, cellphone, dni, nick, password, email);
		this.properties = new ArrayList<Property>();
	}

	@Override
	public int getFlags() {
		return Flag.VIEW | Flag.PROFILE_EDIT | Flag.PROFILE_VIEW | Flag.PROPERTY_DELETE | Flag.PROPERTY_EDIT | Flag.PROPERTY_NEW | Flag.PROPERTY_VIEW;
	}

	public ArrayList<Property> getProperties() {
		return this.properties;
	}

	public void addProperty(Property property) {
		this.properties.add(property);
	}

	public boolean removeProperty(Property property) {
		return this.properties.remove(property);
	}

	public boolean containsProperty(Property property) {
		return this.properties.contains(property);
	}

}
