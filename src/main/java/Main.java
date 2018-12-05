import model.Board;
import model.Player;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] newDeck = getNewDeck();
        System.out.println("New Deck");
        for (Integer i : newDeck) {
            System.out.print(i + " ,");
        }

        int[] shuffledDeck = shuffleDeck(newDeck);
        System.out.println(" ");
        System.out.println("Shuffled Deck");
        for (Integer i : shuffledDeck) {
            System.out.print(i + " ,");
        }

        Board b = new Board(shuffledDeck);
        b.addPlayer(new Player("mehmet"));
        b.addPlayer(new Player("sedat"));
        b.addPlayer(new Player("filiz"));
        b.addPlayer(new Player("zeynep"));

        b.deal();

        Player p = b.bestHand();

        System.out.println("Players' hands");
        for (Player player : b.getPlayerList()){
            System.out.println(Arrays.toString(player.getHand()));
        }

        System.out.println("Best Hand");
        System.out.println(Arrays.toString(p.getHand()));

    }

    private static int[] getNewDeck() {
        int[] newDeck = new int[106];
        for (int i = 0; i < 53; i++) {
            newDeck[i] = i;
            newDeck[i + 53] = i;
        }
        return newDeck;
    }

    private static int[] shuffleDeck(int[] deck) {
        Random generator = new Random();
        int[] shuffledDeck = new int[106];
        int i = 0;
        while (deck.length > 0) {
            int randomNo = generator.nextInt(deck.length);
            shuffledDeck[i++] = deck[randomNo];
            deck = ArrayUtils.remove(deck, randomNo);
        }
        return shuffledDeck;
    }
}
