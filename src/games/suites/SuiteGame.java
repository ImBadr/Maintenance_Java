package games.suites;

import api.game.BaseGame;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SuiteGame extends BaseGame {

	public SuiteGame() {
		super("Suite");
	}

	@Override
	public void start() {
		super.start();
		List<Suite> suites = Arrays.asList(
				new SuiteMystère(),
				new SuiteArithmétique(1, 10),
				new SuiteArithmétique(7, 25),
				new SuiteGéométrique(1, 10),
				new SuiteGéométrique(7, 25)
		);
		Random           r        = new Random();
		Suite            suite    = suites.get(r.nextInt(suites.size()));
		final int        NB       = getArgs().length > 0 && getArgs()[0].equals("-hard") ? 3 : 4;
		List<BigInteger> termes   = suite.premiersTermes(NB + 1);
		BigInteger       aTrouver = termes.remove(NB);
		System.out.println("Trouvez l'entier qui suit logiquement la suite suivante : " + termes);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BigInteger valeur = new BigInteger(sc.next()); // peut lever NumberFormatException
		if (valeur.equals(aTrouver)) {
			this.setWin(true);
			System.out.println("Bravo");
		} else {
			this.setWin(false);
			System.out.println("Dommage");
		}
	}
}
