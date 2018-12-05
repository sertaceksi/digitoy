package model;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] hand;
    private int handPower;

    public int getHandPower() {
        return handPower;
    }

    public void setHandPower(int handPower) {
        this.handPower = handPower;
    }

    public void valueOfHand() {
        int[] playerHand = this.getHand();
        int count;
        Arrays.sort(playerHand);
        for (int i = 0; i < playerHand.length - 1; i++) {
            if (playerHand[i] == playerHand[i + 1] - 1 && (playerHand[i] % 13) + 1 == (playerHand[i + 1] % 13)) {
                if ((i + 2 < playerHand.length) && (playerHand[i] == playerHand[i + 2] - 2) && (playerHand[i] % 13) + 2 == (playerHand[i + 2] % 13)) {
                    this.addHandPower(3);
                    i=i+2;
                    if ((i + 3 < playerHand.length) && playerHand[i] == playerHand[i + 3] - 3 && (playerHand[i] % 13) + 3 == (playerHand[i + 3] % 13)) {
                        this.addHandPower(1);
                        i=i+1;
                    }
                }
            } else {
                count = 0;
                for (int j = 0; j < playerHand.length - i; j++) {
                    if (playerHand[i] != playerHand[j] && playerHand[i] % 13 == playerHand[j] % 13) {
                        count++;
                    }
                }
                if (count > 2) {
                    this.addHandPower(count);
                }
            }
        }
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.setHandPower(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getHand() {
        return hand;
    }

    public void setHand(int[] hand) {
        Arrays.sort(hand);
        this.hand = hand;
        this.valueOfHand();

    }

    private void addHandPower(int valueToAdd) {
        this.handPower += valueToAdd;
    }
}
