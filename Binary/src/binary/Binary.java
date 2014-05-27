package binary;

public class Binary {

	public static int DecinalToBinary(int num) {

		String binary = "";

		while (true) {
			binary += String.valueOf(num % 2);
			
			System.out.println(num);
			
			if (num < 2)
				break;
			
			num /= 2;

		}

		return Integer.parseInt(new StringBuilder(binary).reverse().toString());
	}

}
