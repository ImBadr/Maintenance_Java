package api.party;

import api.game.Game;

import java.util.List;
import java.util.Map;

/**
 * Interface représentant un assemblage
 *
 * @author Badr Tadjer
 */
public interface Party extends Game {

	/**
	 * Retourne la liste des jeux de l'assemblage
	 *
	 * @return la liste des jeux
	 */
	List<Game> getGames();

	Map<String, Boolean> getHistory();

	/**
	 * Indique si le jeu est fini
	 *
	 * @return <tt>true</tt>si on peut recommencer à joueur
	 */
	boolean canRetry();

	/**
	 * Retourne le type de l'assembleur
	 *
	 * @return le type de l'assembleur
	 */
	String getType();

}
