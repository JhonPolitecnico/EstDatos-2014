package kernel.lagrange.polynomial;

public class Math {

	public float absoluteValue(float number) {
		return (number >= 0) ? number : -number;
	}

	public long binomialCoefficient(int set, int subset) {
		return factorial(set) / (factorial(subset) * factorial(set - subset));
	}

	public long factorial(int number) {
		return (number == 1) ? number : number * factorial(number - 1);
	}

	public float solve(float value, String variable, String equation) {
		float ret = 1;
		equation = equation.replace(" ", ""); // Remove spaces
		equation = equation.replace(variable, String.valueOf(value)); // Remove spaces
		for (String subset : equation.split("\\)")) {
			subset = subset.replace("(", "");
			ret *= solveOperation(subset);
		}
		return ret;
	}

	public float solveOperation(String exp) {
		String[] op = (exp.split("((?<=\\-|\\+|\\*|\\/)|(?=\\-|\\+|\\*|\\/))", 3));

		if (op.length != 3)
			return 0;

		if (op[1].equals("+")) {
			return Float.parseFloat(op[0]) + Float.parseFloat(op[2]);
		} else if (op[1].equals("-")) {
			return Float.parseFloat(op[0]) - Float.parseFloat(op[2]);
		} else if (op[1].equals("*")) {
			return Float.parseFloat(op[0]) * Float.parseFloat(op[2]);
		} else if (op[1].equals("/")) {
			return Float.parseFloat(op[0]) / Float.parseFloat(op[2]);
		}

		return 0;

	}

}
