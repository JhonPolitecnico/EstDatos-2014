package binary;

public class Binary {

	public static int decinalToBinary(int num) {

		String binary = "";

		while (true) {
			binary += String.valueOf(num % 2);

			if (num < 2)
				break;

			num /= 2;

		}

		return Integer.parseInt(new StringBuilder(binary).reverse().toString());
	}

	public static int binarySum(int num, int num2) {

		String binary = "";

		while (true) {
			binary += String.valueOf(num % 2);

			if (num < 2)
				break;

			num /= 2;

		}

		return Integer.parseInt(new StringBuilder(binary).reverse().toString());
	}

}
