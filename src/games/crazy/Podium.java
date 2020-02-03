package games.crazy;

import java.util.LinkedList;



public class Podium {
	private LinkedList<Animal> animaux;
	
	public Podium() {
		animaux = new LinkedList<>();
	}

	public Podium(Animal a1) {
		this();
		accueuillir(a1);
	}

	public Podium(Animal a1, Animal a2) {
		this(a1);
		accueuillir(a2);
	}

	public Podium(Animal a1, Animal a2, Animal a3) {
		this(a1, a2);
		accueuillir(a3);
	}
	
	public Podium(Podium p) {
		animaux = new LinkedList<>(p.animaux);
	}

	public boolean estVide() {
		return animaux.isEmpty();
	}
	
	public boolean contient(Animal a) {
		return animaux.contains(a);
	}
	
	public void accueuillir(Animal a) {
		if (contient(a))
			throw new IllegalArgumentException("un podium ne peut pas avoir deux fois le meme animal");
		animaux.addLast(a);
	}
	
	public Animal expulser() {
		if (estVide())
			throw new IllegalStateException("saut alors que le podium est vide");
		return animaux.removeLast();
	}
	
	public void permuter() {
		if (estVide())
			throw new IllegalStateException("permutation alors que le podium est vide");
		if (animaux.size() > 1)
			animaux.addLast(animaux.removeFirst());
	}
	
	@Override
	public String toString() {
		return animaux.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Podium other = (Podium) obj;
		return animaux.equals(other.animaux);
	}

	@Override
	public int hashCode() {
		return animaux.hashCode();
	}
}
