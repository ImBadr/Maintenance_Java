package games.pppg;

import api.game.BaseGame;

import java.util.Random;
import java.util.Scanner;

public class PlusPetitPlusGrandGame extends BaseGame {

    public PlusPetitPlusGrandGame() {
        super("Plus Petit ou Plus Grand");
    }

    @Override
    public void start() {
    	super.start();
        final int MAX = getArgs().length > 0 && getArgs()[0].equals("-hard") ? 1000 : 100;
        final long NB = Math.round(Math.log(MAX) / Math.log(2));

        System.out.println("Vous devez trouver une valeur comprise entre 1 et " + MAX + " en moins de " + NB + " tentatives");

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int aTrouver = 1 + new Random().nextInt(MAX);
        System.out.println("Entrez une valeur");
        int valeur = sc.nextInt();
        int nb = 1;
        while (valeur != aTrouver && nb < NB) {
            if (valeur < aTrouver)
                System.out.println("c'est plus grand");
            else
                System.out.println("c'est plus petit");
            System.out.println("Entrez une valeur");
            valeur = sc.nextInt();
            ++nb;
        }
        if (valeur == aTrouver) {
            this.setWin(true);
            System.out.println("Bravo");
        } else {
            this.setWin(false);
            System.out.println("Dommage");
        }
    }
}
