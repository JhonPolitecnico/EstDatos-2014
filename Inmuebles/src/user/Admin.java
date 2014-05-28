package user;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.mask.Flag;

public class Admin extends User implements Rol {

	public Admin(String name, String surname, int phone, int cellphone, int dni, String nick, String password, String email) {
		super(name, surname, phone, cellphone, dni, nick, password, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getFlags() {
		return Flag.VIEW | Flag.ADMIN_PROFILE_EDIT | Flag.ADMIN_PROPERTY_DELETE | Flag.ADMIN_PROPERTY_EDIT | Flag.PROFILE_EDIT | Flag.PROFILE_VIEW;
	}

}
