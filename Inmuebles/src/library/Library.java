package library;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;
import java.util.ArrayList;

import user.Rol;

/**
 * Skeleton file library
 * 
 */
public class Library implements Serializable {

	private static final long serialVersionUID = -5257925178112784390L;

	private ArrayList<Rol> roles;

	public Library(ArrayList<Rol> roles) {
		super();
		this.roles = roles;
	}

	public ArrayList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}

}
