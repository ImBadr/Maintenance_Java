package games.suites;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SuiteArithmétique implements Suite {
	private BigInteger u0;
	private BigInteger raison;
	
	public SuiteArithmétique(int min, int max) {
		Random r = new Random();
		this.u0 = new BigInteger(Integer.toString(min + r.nextInt(max + 1 - min)));
		this.raison = new BigInteger(Integer.toString(min + r.nextInt(max + 1 - min)));
	}
	
	public BigInteger raison() {
		return raison;
	}
	
	protected BigInteger suivant(BigInteger courant) {
		return courant.add(raison);
	}
	
	//@Override
	public List<BigInteger> premiersTermes(int n) {
		LinkedList<BigInteger> termes = new LinkedList<>();
		BigInteger courant = u0;
		while (termes.size() < n) {
			if (!termes.isEmpty())
				courant = suivant(courant);
			termes.add(courant);
		}
		return termes;
	}
}
