package games.tictactoe;

public class Coord {
	public final int ligne;
	public final int col;

	public Coord(int ligne, int colonne) {
		this.ligne = ligne;
		this.col = colonne;
	}
	
	public Coord plus(Coord c) {
		return new Coord(ligne + c.ligne, col + c.col);
	}
}