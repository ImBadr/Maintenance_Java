package games.suites;

import java.math.BigInteger;

public class SuiteGéométrique extends SuiteArithmétique {

	public SuiteGéométrique(int min, int max) {
		super(min, max);
	}

	@Override
	protected BigInteger suivant(BigInteger courant) {
		return courant.multiply(raison());
	}
}
