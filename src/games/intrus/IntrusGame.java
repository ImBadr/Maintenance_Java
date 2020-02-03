package games.intrus;

import api.game.BaseGame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class IntrusGame extends BaseGame {

    public IntrusGame() {
        super("Intrus");
    }

    private static class Question {
        public final List<String> mots;
        public final int intrus;

        public Question(List<String> mots, int intrus) {
            if (mots == null || intrus < 1 || intrus > mots.size())
                throw new IllegalArgumentException();
            this.mots = mots;
            this.intrus = intrus;
        }
    }

    @Override
    public void start() {
        super.start();
        List<Question> questions = Arrays.asList(
                new Question(Arrays.asList("pomme", "ananas", "poisson", "citron"), 3),
                new Question(Arrays.asList("fer", "igloo", "acier", "brique"), 2),
                new Question(Arrays.asList("eau", "lait", "jus", "fruit"), 4),
                new Question(Arrays.asList("chien", "table", "porte", "mur"), 1),
                new Question(Arrays.asList("chat", "girafe", "baleine", "histoire", "éléphant"), 4),
                new Question(Arrays.asList("stylo", "étiquette", "pinceau", "crayon"), 2),
                new Question(Arrays.asList("beau", "belle", "gentil", "lit", "agréable"), 4),
                new Question(Arrays.asList("dormir", "manger", "particulier", "rêver"), 3),
                new Question(Arrays.asList("photo", "image", "poster", "carton"), 4),
                new Question(Arrays.asList("plume", "dune", "poil", "duvet"), 2)
        );
        Random r = new Random();
        Question q = questions.get(r.nextInt(questions.size()));
        System.out.println("Donnez le numéro de l'intrus parmi les mots qui suivent");
        int i = 0;
        for (String m : q.mots)
            System.out.println((++i) + " : " + m);
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        try {
            int intrus = sc.nextInt();
            if (intrus == q.intrus) {
                this.setWin(true);
                System.out.println("Bravo");
            } else {
                this.setWin(false);
                System.out.println("Dommage");
            }
        } catch (Exception e) {
            this.setWin(true);
            System.out.println("Raté");
        }
    }
}
