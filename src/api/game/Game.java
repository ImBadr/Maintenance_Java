package api.game;

/**
 * Interface repr�sentant un jeu
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
	 * Retourne l'�tat de la partie
	 *
	 * @return <tt>true</tt> si la partie est gagn�e
	 */
	boolean isWon();

	/**
	 * Changement de l'�tat de la partie
	 *
	 * @param b �tat de la partie
	 */
	void setWin(boolean b);

	/**
	 * Retourne le nom du jeu
	 *
	 * @return le nom du jeu
	 */
	String getName();

}
