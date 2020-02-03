package games.suites;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class SuiteMystère implements Suite {
	@Override
	public List<BigInteger> premiersTermes(int n) {
		LinkedList<BigInteger> termes = new LinkedList<>();
		BigInteger courant = BigInteger.ONE;
		while (termes.size() < n) {
			if (!termes.isEmpty()) {
				char[] chiffres = courant.toString().toCharArray();
				courant = BigInteger.ZERO;
				for (int i = 0; i < chiffres.length;) {
					char c = chiffres[i];
					int nb = 1;
					for (++i; i < chiffres.length && c == chiffres[i]; ++i)
						++nb;
					courant = courant.multiply(BigInteger.TEN).add(new BigInteger(Integer.toString(nb)));
					courant = courant.multiply(BigInteger.TEN).add(new BigInteger(Integer.toString(c - '0')));
				}
			}
			termes.add(courant);
		}
		return termes;
	}
}
