package Main;

/***********************************************************************
 * Module:  Cliente.java
 * Author:  Hax0r
 * Purpose: Defines the Class Cliente
 ***********************************************************************/

import java.util.*;

/** @pdOid 7d0c7929-6050-4b72-b187-fa6b57deb9aa */
public class Cliente extends Persona {
	/** @pdOid c59d32a8-12a5-4db0-87ee-6d691f8323f2 */
	private int phone;

	public Cliente(String name, String address, int phone) {
		super(name, address);
		this.phone = phone;
	}

	/** @pdOid b29c52f2-2111-4197-8384-9596013281d3 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param newPhone
	 * @pdOid 3c66dcce-59ef-4948-b2ed-3fe5bfe41bba
	 */
	public void setPhone(int newPhone) {
		phone = newPhone;
	}

}