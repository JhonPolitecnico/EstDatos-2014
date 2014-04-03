package kernel.lagrange.polynomial;

public class Math {

	public static float solveLagrangePolynomial(P p, float valueOfX) {
		float fRet = 0;

		PSub pSub = null;
		// Resolver un polinomio interpolador de lagrange
		for (int i = 0; i < p.getParts().length; i++) {
			pSub = p.getParts()[i];
			// Resolver un polinomio de lagrange con su punto 'y'
			fRet += pSub.getMultiplicand() * (Math.solve(valueOfX, "x", pSub.getMultiplier().getxNumeratorResult()) / pSub.getMultiplier().getxDenominatorResult());
		}

		return fRet;
	}

	public static float absoluteValue(float number) {
		return (number >= 0) ? number : -number;
	}

	public static long binomialCoefficient(int set, int subset) {
		return factorial(set) / (factorial(subset) * factorial(set - subset));
	}

	public static long factorial(int number) {
		return (number <= 1) ? number : number * factorial(number - 1);
	}

	public static float solve(float value, String variable, String equation) {
		float ret = 1;
		equation = equation.replace(" ", ""); // Remove spaces
		equation = equation.replace(variable, String.valueOf(value)); // Remove spaces
		for (String subset : equation.split("\\)")) {
			subset = subset.replace("(", "");
			ret *= solveOperation(subset);
		}
		return ret;
	}

	public static float solveOperation(String exp) {
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
