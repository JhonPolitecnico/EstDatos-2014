package user.mask;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 * @reference http://en.wikipedia.org/wiki/Mask_%28computing%29
 * @reference http://stackoverflow.com/questions/648021/how-to-use-a-bitwise-operator-to-pass-multiple-integer-values-into-a-function-fo
 * 
 */
public class Flag {

	/**
	 * View
	 */
	public final static int VIEW = 0x01;
	/**
	 * View your profile
	 */
	public final static int PROFILE_VIEW = 0x02;
	/**
	 * Edit your profile
	 */
	public final static int PROFILE_EDIT = 0x04;
	/**
	 * View your properties
	 */
	public final static int PROPERTY_VIEW = 0x08;
	/**
	 * Create your property
	 */
	public final static int PROPERTY_NEW = 0x10;
	/**
	 * Edit your property
	 */
	public final static int PROPERTY_EDIT = 0x20;
	/**
	 * Delete your property
	 */
	public final static int PROPERTY_DELETE = 0x40;

	/**
	 * Edit profiles
	 */
	public final static int ADMIN_PROFILE_EDIT = 0x80;
	/**
	 * Edit properties
	 */
	public final static int ADMIN_PROPERTY_EDIT = 0x100;
	/**
	 * Delete properties
	 */
	public final static int ADMIN_PROPERTY_DELETE = 0x200;

	public static boolean isFlag(final int flags, final int flag) {
		return (flags & flag) != 0;
	}
}
