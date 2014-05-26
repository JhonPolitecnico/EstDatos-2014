package user.mask;

/**
 * 
 * @reference http://en.wikipedia.org/wiki/Mask_%28computing%29
 * @reference http://stackoverflow.com/questions/648021/how-to-use-a-bitwise-operator-to-pass-multiple-integer-values-into-a-function-fo
 * 
 */
public class Flag {

	public final static int VIEW = 0x01;
	public final static int USER_EDIT = 0x02;
	public final static int USER_DELETE = 0x04;
	public final static int ADMIN_EDIT = 0x08;
	public final static int ADMIN_DELETE = 0x10;

	public static void test() {

		display(VIEW);
		display(USER_EDIT);
		display(USER_DELETE);
		display(ADMIN_EDIT);
		display(ADMIN_DELETE);

		display(VIEW | USER_EDIT);
		display(VIEW | USER_DELETE);
		display(VIEW | ADMIN_EDIT);
		display(VIEW | ADMIN_DELETE);
		display(USER_EDIT | USER_DELETE);
		display(USER_EDIT | ADMIN_EDIT);
		display(USER_EDIT | ADMIN_DELETE);
		display(USER_DELETE | ADMIN_EDIT);
		display(USER_DELETE | ADMIN_DELETE);
		display(ADMIN_EDIT | ADMIN_DELETE);

		display(VIEW | USER_EDIT | USER_DELETE);
		display(VIEW | USER_EDIT | ADMIN_EDIT);
		display(VIEW | USER_EDIT | ADMIN_DELETE);
		display(VIEW | USER_DELETE | ADMIN_EDIT);
		display(VIEW | USER_DELETE | ADMIN_DELETE);
		display(VIEW | ADMIN_EDIT | ADMIN_DELETE);
		display(USER_EDIT | USER_DELETE | ADMIN_EDIT);
		display(USER_EDIT | USER_DELETE | ADMIN_DELETE);
		display(USER_EDIT | ADMIN_EDIT | ADMIN_DELETE);
		display(USER_DELETE | ADMIN_EDIT | ADMIN_DELETE);

		display(VIEW | USER_EDIT | USER_DELETE | ADMIN_EDIT);
		display(VIEW | USER_EDIT | USER_DELETE | ADMIN_DELETE);
		display(VIEW | USER_EDIT | ADMIN_EDIT | ADMIN_DELETE);
		display(VIEW | USER_DELETE | ADMIN_EDIT | ADMIN_DELETE);
		display(USER_EDIT | USER_DELETE | ADMIN_EDIT | ADMIN_DELETE);

		display(VIEW | USER_EDIT | USER_DELETE | ADMIN_EDIT | ADMIN_DELETE);
	}

	public static boolean isFlag(final int flags, final int flag) {
		return (flags & flag) != 0;
	}

	private static void display(final int val) {
		System.out.print(((val & VIEW) != 0) ? "VIEW | " : "");
		System.out.print(((val & USER_EDIT) != 0) ? "USER_EDIT | " : "");
		System.out.print(((val & USER_DELETE) != 0) ? "USER_DELETE | " : "");
		System.out.print(((val & ADMIN_EDIT) != 0) ? "ADMIN_EDIT | " : "");
		System.out.print(((val & ADMIN_DELETE) != 0) ? "ADMIN_DELETE | " : "");
		System.out.println();
	}

}
