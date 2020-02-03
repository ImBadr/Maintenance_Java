package parties;

import api.party.BaseParty;

/**
 * Classe repr�sentant un assemblage "Tant que".
 * <p>
 * Tant que tous les jeux de cet assemblage ne seront pas gagn�s, le jeu recommencera.
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
