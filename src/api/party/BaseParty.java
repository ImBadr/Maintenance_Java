package api.party;

import api.game.Game;

import java.util.*;

/**
 * Classe représentant un assemblage simple (jouable une ou n fois)
 *
 * @author Cédric / Triozer
 */
public class BaseParty implements Party {

	private final List<Game>           parties;
	private final Map<String, Boolean> history;
	private final int                  repeat;
	private       int                  current_tries;
	private       boolean              win;

	/**
	 * Constructeur d'une partie avec un nombre de fois à jouer donné
	 *
	 * @param repeat nombre de fois à jouer
	 */
	public BaseParty(int repeat) {
		this.parties = new ArrayList<>();
		this.history = new HashMap<>();
		this.repeat = repeat;
		this.win = false;
	}

	/**
	 * Constructeur d'une partie jouable une fois
	 */
	public BaseParty() {
		this(1);
	}

	/**
	 * Ajouter des jeux à cet assemblage.
	 *
	 * @param games les jeux à ajouter
	 * @return la partie avec les jeux ajoutés
	 */
	public BaseParty add(Game... games) {
		this.parties.addAll(Arrays.asList(games));
		return this;
	}

	@Override
	public void start() {
		this.current_tries = this.repeat;
		while (canRetry()) {
			for (Game game : this.parties) {
				try {
					game.start();
				} catch (Exception e) {
					game.setWin(true);
				}
				this.history.put(this.current_tries + " " + game.getName(), game.isWon());
			}
			this.current_tries--;
		}
	}

	@Override
	public boolean canRetry() {
		return this.current_tries != 0;
	}

	@Override
	public boolean isWon() {
		return this.win || this.parties.stream().filter(Game::isWon).count() == this.parties.size();
	}

	@Override
	public void setWin(boolean b) {
		this.win = b;
	}

	@Override
	public String getName() {
		StringBuilder name = new StringBuilder("Assemblage" + getType() + "de ");
		this.parties.forEach(game -> {
			name.append("\"").append(game.getName()).append("\"");
			if (this.parties.size() > 1 && this.parties.get(this.parties.size() - 2) == game)
				name.append(" et de ");
			else if (this.parties.get(this.parties.size() - 1) != game)
				name.append(", ");

		});
		return name.toString();
	}

	public int getCurrentTries() {
		return this.current_tries;
	}

	public void setCurrentTries(int current_tries) {
		this.current_tries = current_tries;
	}

	public int getRepeat() {
		return this.repeat;
	}

	@Override
	public List<Game> getGames() {
		return this.parties;
	}

	@Override
	public Map<String, Boolean> getHistory() {
		return this.history;
	}

	@Override
	public String getType() {
		return " ";
	}

}

