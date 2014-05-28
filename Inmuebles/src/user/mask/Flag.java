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

	public final static int VIEW = 0x01;
	public final static int PROPERTY_NEW = 0x02;
	public final static int PROPERTY_EDIT = 0x04;
	public final static int PROPERTY_DELETE = 0x08;
	public final static int ADMIN_PROPERTY_EDIT = 0x10;
	public final static int ADMIN_PROPERTY_DELETE = 0x20;

	public static boolean isFlag(final int flags, final int flag) {
		return (flags & flag) != 0;
	}
}
