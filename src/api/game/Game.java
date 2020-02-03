package api.game;

/**
 * Interface représentant un jeu
 *
 * @author Badr Tadjer
 */
public interface Game {

	/**
	 * Lance une partie
	 *
	 * @throws Exception exceptions
	 */
	void start() throws Exception;

	/**
	 * Retourne l'état de la partie
	 *
	 * @return <tt>true</tt> si la partie est gagnée
	 */
	boolean isWon();

	/**
	 * Changement de l'état de la partie
	 *
	 * @param b état de la partie
	 */
	void setWin(boolean b);

	/**
	 * Retourne le nom du jeu
	 *
	 * @return le nom du jeu
	 */
	String getName();

}
