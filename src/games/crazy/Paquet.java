package games.crazy;

import static games.crazy.Animal.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Paquet {
	private ArrayList<Carte> cartes;
	
	public Paquet() {
		cartes = new ArrayList<>(Arrays.asList(
				  new Carte(new Podium(ELEPHANT, OURS, LION), new Podium())
				, new Carte(new Podium(ELEPHANT, LION, OURS), new Podium())
				, new Carte(new Podium(OURS, ELEPHANT, LION), new Podium())
				, new Carte(new Podium(OURS, LION, ELEPHANT), new Podium())
				, new Carte(new Podium(LION, OURS, ELEPHANT), new Podium())
				, new Carte(new Podium(LION, ELEPHANT, OURS), new Podium())
				, new Carte(new Podium(), new Podium(ELEPHANT, OURS, LION))
				, new Carte(new Podium(), new Podium(ELEPHANT, LION, OURS))
				, new Carte(new Podium(), new Podium(OURS, ELEPHANT, LION))
				, new Carte(new Podium(), new Podium(OURS, LION, ELEPHANT))
				, new Carte(new Podium(), new Podium(LION, OURS, ELEPHANT))
				, new Carte(new Podium(), new Podium(LION, ELEPHANT, OURS))
				, new Carte(new Podium(OURS, LION), new Podium(ELEPHANT))
				, new Carte(new Podium(LION, OURS), new Podium(ELEPHANT))
				, new Carte(new Podium(ELEPHANT, LION), new Podium(OURS))
				, new Carte(new Podium(LION, ELEPHANT), new Podium(OURS))
				, new Carte(new Podium(OURS, ELEPHANT), new Podium(LION))
				, new Carte(new Podium(ELEPHANT, OURS), new Podium(LION))
				, new Carte(new Podium(ELEPHANT), new Podium(OURS, LION))
				, new Carte(new Podium(ELEPHANT), new Podium(LION, OURS))
				, new Carte(new Podium(OURS), new Podium(ELEPHANT, LION))
				, new Carte(new Podium(OURS), new Podium(LION, ELEPHANT))
				, new Carte(new Podium(LION), new Podium(OURS, ELEPHANT))
				, new Carte(new Podium(LION), new Podium(ELEPHANT, OURS))
				));
		Collections.shuffle(cartes);
	}
	
	public boolean estVide() {
		return cartes.isEmpty();
	}
	
	// lève IndexOutOfBoundsException si le paquet est vide
	public Carte piocher() {
		return cartes.remove(cartes.size() - 1);
	}
}