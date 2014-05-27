package user;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.mask.Flag;

public class Guest implements Rol {

	@Override
	public int getFlags() {
		return Flag.VIEW;
	}

}
