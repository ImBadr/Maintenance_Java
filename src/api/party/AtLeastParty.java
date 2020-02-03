package api.party;

import api.game.Game;

/**
 * Classe repr�sentant un assemblage "Au moins n".
 * <p>
 * Si au moins n jeux de l'assemblage sont gagn�s, alors c'est bon. Sinon, le jeu recommmence.
 *
 * @author C�dric / Triozer
 */
public class AtLeastParty extends BaseParty {

	private final int n;

	/**
	 * Constructeur d'une partie avec un nombre de jeu � gagner au minimum
	 *
	 * @param n nombre de jeu � gagner
	 */
	public AtLeastParty(int n) {
		this.n = n;
	}

	@Override
	public void start() {
		if (this.getGames().size() >= n)
			super.start();
		else
			throw new RuntimeException("Pour pouvoir d�marrer, cet assembleur requiert + de " + this.n + " jeu"
					+ (this.n <= 1 ? '.' : "x."));
	}

	@Override
	public boolean isWon() {
		return this.getGames().stream().filter(Game::isWon).count() >= this.n;
	}

	@Override
	public boolean canRetry() {
		return !this.isWon();
	}

	public int getN() {
		return n;
	}

	@Override
	public String getType() {
		return " Au moins " + this.n + " ";
	}

}
