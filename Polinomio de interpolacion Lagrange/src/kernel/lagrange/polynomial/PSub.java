package kernel.lagrange.polynomial;

public class PSub {

	private float multiplicand;
	private L multiplier;

	public PSub(float multiplicand, L multiplier) {
		super();
		this.multiplicand = multiplicand;
		this.multiplier = multiplier;
	}

	public float getMultiplicand() {
		return multiplicand;
	}

	public L getMultiplier() {
		return multiplier;
	}

}
