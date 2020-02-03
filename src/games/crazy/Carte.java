package games.crazy;

public class Carte {
	private final Podium bleu;
	private final Podium rouge;
	
	public Carte(Podium b, Podium r) {
		for (Animal a : Animal.values()) {
			if (!b.contient(a) && !r.contient(a))
				throw new IllegalArgumentException(a + " est absent des 2 podiums");
			if (b.contient(a) && r.contient(a))
				throw new IllegalArgumentException(a + " est présent sur les 2 podiums");
		}
		bleu = b;
		rouge = r;
	}
	
	private Carte(Carte c) {
		this(new Podium(c.bleu), new Podium(c.rouge));
	}
	
	public Carte ki() {
		Carte c = new Carte(this);
		c.rouge.accueuillir(c.bleu.expulser());
		return c;
	}
	
	public Carte lo() {
		Carte c = new Carte(this);
		c.bleu.accueuillir(c.rouge.expulser());
		return c;
	}
	
	public Carte so() {
		Carte c = new Carte(this);
		Animal a = c.bleu.expulser();
		c.bleu.accueuillir(c.rouge.expulser());
		c.rouge.accueuillir(a);
		return c;
	}
	
	public Carte ni() {
		Carte c = new Carte(this);
		c.bleu.permuter();
		return c;
	}
	
	public Carte ma() {
		Carte c = new Carte(this);
		c.rouge.permuter();
		return c;
	}
	
	@Override
	public String toString() {
		return bleu + " - " + rouge;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return bleu.equals(other.bleu) && rouge.equals(other.rouge);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + bleu.hashCode();
		return prime * result + rouge.hashCode();
	}
}
