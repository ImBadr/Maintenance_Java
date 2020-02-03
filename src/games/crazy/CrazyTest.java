package games.crazy;

import org.junit.Test;

import java.util.ArrayList;

import static games.crazy.Animal.*;
import static org.junit.Assert.*;

public class CrazyTest {
	@Test
	public void testPodium() {
		Podium p = new Podium();
		assertTrue(p.estVide());
		assertFalse(p.contient(Animal.ELEPHANT));
		p.accueuillir(Animal.ELEPHANT);
		assertFalse(p.estVide());
		assertTrue(p.contient(Animal.ELEPHANT));
		p.accueuillir(Animal.OURS);
		p.permuter();
		Animal a = p.expulser();
		assertEquals(Animal.ELEPHANT, a);
		assertFalse(p.contient(Animal.ELEPHANT));
		assertTrue(p.contient(Animal.OURS));
	}

	@Test
	public void testCarte() {
		Carte d = new Carte(new Podium(ELEPHANT, OURS, LION), new Podium());
		Carte o = new Carte(new Podium(OURS), new Podium(ELEPHANT, LION));
		assertEquals(o, d.ni().ki().ki());
	}
	
	@Test
	public void testPaquet() {
		Paquet p = new Paquet();
		ArrayList<Carte> cartes = new ArrayList<>();
		while (!p.estVide())
			cartes.add(p.piocher());
		assertEquals(cartes.size(), 24);
		for (int i = 0; i < cartes.size(); ++i)
			for (int j = i + 1; j < cartes.size(); ++j)
				assertNotEquals(cartes.get(i), cartes.get(j));
	}
}
