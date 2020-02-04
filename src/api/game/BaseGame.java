package api.game;

import java.util.Scanner;

/**
 * Classe représentant un jeu simple (jouable une fois)
 *
 * @author Badr Tadjer
 */
public abstract class BaseGame implements Game {

	private final String   name;
	private       String[] args;
	private       boolean  useArgs;
	private       boolean  won;

	/**
	 * Constructeur d'un jeu
	 *  @param name    le nom du jeu
	 *
	 */
	public BaseGame(String name) {
		this.name = name;
		this.won = false;
		this.useArgs = false;
	}

	@Override
	public void start() {
		if (this.useArgs && this.args == null) {
			this.args = new Scanner(System.in).nextLine().split(" ");
		}
	}

	@Override
	public boolean isWon() {
		return this.won;
	}

	@Override
	public void setWin(boolean b) {
		this.won = b;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String[] getArgs() {
		return this.args;
	}

}
