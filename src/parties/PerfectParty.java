package parties;

import api.game.Game;
import api.party.BaseParty;

/**
 * Classe représentant un assemblage "Parfait".
 * <p>
 * Tous les jeux de l'assemblage doivent être gagnés.
 *
 * @author Cédric / Triozer
 */
public class PerfectParty extends BaseParty {

	public PerfectParty(int repeat) {
		super(repeat);
	}

	@Override
	public void start() {
		this.setCurrentTries(this.getRepeat());
		while (canRetry()) {
			for (Game game : this.getGames()) {
				try {
					game.start();
					if (!game.isWon()) {
						break;
					}
				} catch (Exception e) {
					game.setWin(true);
				}
				this.getHistory().put(this.getCurrentTries() + " " + game.getName(), game.isWon());
			}
			this.setCurrentTries(this.getCurrentTries() - 1);
		}
	}

	@Override
	public String getType() {
		return " Parfait ";
	}

}
