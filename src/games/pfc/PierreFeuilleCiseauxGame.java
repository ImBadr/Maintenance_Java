package games.pfc;

import api.game.BaseGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PierreFeuilleCiseauxGame extends BaseGame {

	public PierreFeuilleCiseauxGame() {
		super("Pierre Feuille Ciseaux");
	}

	enum Choix {
		Pierre, Feuille, Ciseaux;

		public boolean estPlusFortQue(Choix c) {
			switch (this) {
				case Pierre:
					return c == Choix.Ciseaux;
				case Feuille:
					return c == Choix.Pierre;
				case Ciseaux:
					return c == Choix.Feuille;
			}
			return false;
		}
	}

	@Override
	public void start() {
		super.start();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Random    r    = new Random();
		final int MAX  = 3;
		int       moi  = 0;
		int       vous = 0;
		System.out.println("On joue à " + Arrays.toString(Choix.values()));
		System.out.println("Le premier de nous deux qui remporte " + MAX + " manches gagne la partie");
		while (vous < MAX && moi < MAX) {
			Choix mien = Choix.values()[r.nextInt(Choix.values().length)];
			System.out.println("Donnez votre choix et je vous montrerais celui que j'ai déjà fait : ");
			try {
				Choix sien = Choix.valueOf(s.next());
				System.out.println("j'ai joué " + mien);
				if (sien.estPlusFortQue(mien))
					++vous;
				else if (mien.estPlusFortQue(sien))
					++moi;
			} catch (IllegalArgumentException e) { // levée par Choix.valueOf(..) ci-dessus.
				System.out.println("ce n'est pas un coup légal, vous devez choisir parmi " + Arrays.toString(Choix.values()));
				this.setWin(true);
			}
			System.out.println("vous avez " + vous + " point(s) et moi " + moi + " point(s)");
		}
		if (vous > moi) {
			this.setWin(true);
			System.out.println("Bravo");
		} else {
			this.setWin(false);
			System.out.println("Dommage");
		}
	}
}
