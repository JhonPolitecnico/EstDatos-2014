package user;

import user.mask.Flag;

public class Guest implements Rol {

	@Override
	public int getFlags() {
		return Flag.VIEW;
	}

}
