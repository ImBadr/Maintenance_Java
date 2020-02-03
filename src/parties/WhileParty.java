package parties;

import api.party.BaseParty;

/**
 * Classe représentant un assemblage "Tant que".
 * <p>
 * Tant que tous les jeux de cet assemblage ne seront pas gagnés, le jeu recommencera.
 *
 * @author Badr Tadjer
 */
public class WhileParty extends BaseParty {

	@Override
	public boolean canRetry() {
		return !this.isWon();
	}

	@Override
	public String getType() {
		return " Tant que ";
	}

}
