package Main;

/***********************************************************************
 * Module:  Persona.java
 * Author:  Hax0r
 * Purpose: Defines the Class Persona
 ***********************************************************************/

import java.util.*;

/** @pdOid d5bda577-70ca-4d2d-801a-58c7d715a743 */
public class Persona {
	/** @pdOid 180910ef-b69f-4013-b1e4-960f3b323db1 */
	private String name;
	/** @pdOid 4ca84713-be9a-4c2c-9abd-6758bf1e5f8a */
	private String address;

	public Persona(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	/** @pdOid 71b880d5-e5a0-4f50-9bb6-03065e3a16c8 */
	public String getName() {
		return name;
	}

	/**
	 * @param newName
	 * @pdOid d163fdbc-f3bf-4850-949b-152132810b6d
	 */
	public void setName(String newName) {
		name = newName;
	}

	/** @pdOid 66e464da-b94e-44eb-b0ca-ee3fb2b37349 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param newAddress
	 * @pdOid e5acf113-9cec-496b-bb1f-0c1f354f15e6
	 */
	public void setAddress(String newAddress) {
		address = newAddress;
	}

}