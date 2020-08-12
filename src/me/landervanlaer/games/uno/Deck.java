package me.landervanlaer.games.uno;

import me.landervanlaer.math.Number;

import java.util.ArrayList;

public class Deck {
    /**
     * All the cards the {@link Deck} is holding
     */
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        initializeDeck();
        shuffle();

        if(getCurrentCardOnTop().canBeFirstCard())
            setTopToUsableCard();
    }

    private void initializeDeck() {
        for(int i = 1; i <= 4; i++) {
            //4 times 0
            getDeck().add(new Card(0, i));

            //1-12, 2 of each color; total = 96
            for(int j = 1; j <= 12; j++) {
                getDeck().add(new Card(j, i));
                getDeck().add(new Card(j, i));
            }
        }
        for(int i = 0; i < 4; i++) {
            getDeck().add(new Card(13, 0));
            getDeck().add(new Card(14, 0));
        }
    }

    private void shuffle() {
        for(int j = 0; j < 2; j++)
            for(int i = 0; i < size(); i++)
                this.swapCards(i, Number.getRandom(0, size()));

    }

    public void placeNewCard(Card card) {
        this.getDeck().add(card);
    }

    public Card getCurrentCardOnTop() {
        return getDeck().get(size() - 1);
    }

    private void setTopToUsableCard() {
        for(int i = 0; i < size(); i++) {
            if(this.getDeck().get(i).canBeFirstCard()) {
                this.swapCards(i, size() - 1);
                break;
            }
        }
    }

    public void swapCards(int i, int j) {
        this.getDeck().set(i, this.getDeck().set(j, getDeck().get(i)));
    }


    public Card takeCard() {
        return getDeck().remove(0).normalize();
    }

    public int size() {
        return getDeck().size();
    }

    private ArrayList<Card> getDeck() {
        return deck;
    }
}
