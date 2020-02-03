package games.pendu;

import java.util.HashSet;

public class Pendu {
	public static final int NB_MAX_ERREURS = 5; 
	private String mot;
	private HashSet<Character> reste;
	private int erreurs;

	public Pendu(String m) {
		mot = m.toUpperCase();
		reste = new HashSet<>();
		for (char c : mot.toCharArray())
			reste.add(c);
		reste.remove(mot.charAt(0));
		reste.remove(mot.charAt(mot.length() - 1));
		erreurs = 0;
	}
	
	public boolean fini() {
		return perdu() || gagné();
	}

	public boolean perdu() {
		return erreurs >= Pendu.NB_MAX_ERREURS;
	}

	public boolean gagné() {
		return reste.isEmpty();
	}

	public boolean jouer(char c) {
		assert (!fini());
		if (reste.contains(c)) {
			reste.remove(c);
			return true;
		}
		++erreurs;
		return false;
	}

	public int nbErreurs() {
		return erreurs;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (char c : mot.toCharArray())
			s.append(reste.contains(c) ? "_" : "" + c);
		return s + ", " + erreurs + " erreur(s)";
	}
}
