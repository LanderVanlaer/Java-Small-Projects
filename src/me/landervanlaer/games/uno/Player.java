package me.landervanlaer.games.uno;

import me.landervanlaer.math.Number;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static Scanner scan = new Scanner(System.in);
    public static final int NUMBER_OF_CARDS_START = 7;
    private ArrayList<Card> cards = new ArrayList<>();
    private String name;
    private int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public Card placeCard(Deck deck) {
        Card choosenCard = null;
        if(!this.canPlaceOnCard(deck.getCurrentCardOnTop())) {
            final Card drawnCard = this.drawCardOfDeck(deck);

            System.out.println("You do not have any usable card");
            System.out.println("Card taking from pile...");
            System.out.printf("New card is: %s%n", drawnCard.toString());

            if(deck.getCurrentCardOnTop().canPutCardOn(drawnCard))
                choosenCard = drawnCard;
        } else
            choosenCard = this.askCard(deck.getCurrentCardOnTop());

        if(choosenCard != null) {
            System.out.printf("You have chosen the card %s%n", choosenCard.toString());
            if(choosenCard.getColor() == 0) choosenCard.pickColour(scan);
        }
        return choosenCard;
    }

    private Card askCard(Card currentCardOnTop) {
        System.out.printf("Player: %s, Total amount of cards: %d%n", getName(), getCards().size());
        System.out.println("Please select a card by giving the index (The number)");
        for(int i = 0; i < getCards().size(); i++)
            if(currentCardOnTop.canPutCardOn(getCards().get(i)))
                System.out.printf("\t--> %d, %s%n", i, getCards().get(i).toString());

        System.out.print("Enter the index of the card you want to use: ");
        String number = scan.next();

        if(Number.isInteger(number)) {
            final int num = Integer.parseInt(number);
            if(num < getCards().size() && num >= 0 && currentCardOnTop.canPutCardOn(getCards().get(num)))
                return getCards().remove(num);
        }
        System.out.println("--------------------------------------------------------\nVALUE (" + number + ") IS NOT A VALID NUMBER\n--------------------------------------------------------\n\n\n");
        return askCard(currentCardOnTop);
    }

    private boolean canPlaceOnCard(Card card) {
        for(int i = 0; i < getCards().size(); i++) {
            if(card.canPutCardOn(getCards().get(i))) return true;
        }
        return false;
    }

    public Card drawCardOfDeck(Deck deck) {
        this.getCards().add(deck.takeCard());
        return this.getCards().get(getCards().size() - 1);
    }

    public void drawCardOfDeck(Deck deck, int i) {
        for(int j = 0; j < i; j++) {
            drawCardOfDeck(deck);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
