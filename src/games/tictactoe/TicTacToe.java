package games.tictactoe;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
	public enum Pièce {
		ROND, CROIX;

		@Override
		public String toString() {
			if (this == ROND)
				return "O";
			return "X";
		}
	}

	public static final int NB = 3;
	private Pièce[][] plateau;

	public TicTacToe() {
		plateau = new Pièce[NB][NB];
		for (Pièce[] ligne : plateau)
			Arrays.fill(ligne, null);
	}

	public boolean estVide(Coord c) {
		return plateau[c.ligne][c.col] == null;
	}

	public void poser(Coord c, Pièce p) {
		if (!estVide(c) || p == null)
			throw new IllegalArgumentException();
		plateau[c.ligne][c.col] = p;
	}

	public boolean fini() {
		if (gagnant() != null)
			return true;
		for (Pièce[] ligne : plateau)
			for (Pièce p : ligne)
				if (p == null)
					return false;
		return true;
	}
	
	private Pièce alignement(Coord origine, Coord direction) {
		if (estVide(origine))
			return null;
		Pièce p = plateau[origine.ligne][origine.col];
		Coord c = origine.plus(direction);
		for (int i = 1; i < NB; ++i, c = c.plus(direction)) 
			if (plateau[c.ligne][c.col] != p)
				return null;
		return p;
	}

	public Pièce gagnant() {
		List<List<Coord>> dirs = Arrays.asList(
				//              origine          direction
				  Arrays.asList(new Coord(0, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(1, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(2, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(0, 0), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 1), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 2), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 0), new Coord(1, 1))
				, Arrays.asList(new Coord(NB - 1, 0), new Coord(-1, 1))
				);
		for (List<Coord> d : dirs) {
			Pièce p = alignement(d.get(0), d.get(1));
			if (p != null)
				return p;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Pièce[] ligne : plateau) {
			for (Pièce p : ligne)
				s.append((p == null ? "." : p) + " ");
			s.append(System.lineSeparator());
		}
		return s.toString();
	}
}
