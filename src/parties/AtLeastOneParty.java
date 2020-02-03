package parties;

import api.party.AtLeastParty;

/**
 * Classe repr�sentant un assemblage "Au moins un".
 * <p>
 * Si au moins un jeu de l'assemblage est gagn�, alors c'est bon. Sinon, le jeu recommmence.
 *
 * @author Badr Tadjer
 */
public class AtLeastOneParty extends AtLeastParty {

	/**
	 * Constructeur d'une partie avec au minimum 1 jeu � gagner
	 */
	public AtLeastOneParty() {
		super(1);
	}

}
