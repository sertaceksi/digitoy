package model;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    public List<Player> getPlayerList() {
        return playerList;
    }

    private List<Player> playerList;
    private int[] deck;

    private int indicator;

    public Board(int[] deck) {
        this.playerList = new ArrayList<Player>();
        this.deck = deck;
    }

    public Board() {
        this.playerList = new ArrayList<Player>();
    }

    public void addPlayer(Player p) {
        if (playerList.size() < 4) {
            playerList.add(p);
        }
    }


    public int getIndicator() {
        return indicator;
    }

    public void deal() {
        if (deck == null || deck.length < 106) {
            System.out.println("Get a Deck for this board..");
        } else {
            Random generator = new Random();
            int k = 0;
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    k = 1;
                }
                playerList.get(i).setHand(ArrayUtils.subarray(deck, i * 14, (i + 1) * 14 + k));
            }


            do {
                indicator = deck[generator.nextInt(49)];
            } while (indicator == 52);//Sahte okey gelirse tekrar
        }
    }

    public Player bestHand() {
        int bestHandValue = -1;
        Player bestHandedPlayer = null;
        for (Player p : playerList) {
            int value = p.getHandPower();
            if (value > bestHandValue) {
                bestHandValue = value;
                bestHandedPlayer = p;
            }
        }
        return bestHandedPlayer;
    }


    public int[] getDeck() {
        return deck;
    }

    public void setDeck(int[] deck) {
        this.deck = deck;
    }
}
