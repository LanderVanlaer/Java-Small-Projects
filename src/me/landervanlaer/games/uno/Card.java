package me.landervanlaer.games.uno;

import me.landervanlaer.math.Number;

import java.util.Scanner;

public class Card {
    protected static final String[] SYMBOLS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "skip", "reverse", "draw two", "wild", "wild draw four"};
    protected static final String[] COLORS = new String[]{"black", "red", "yellow", "blue", "green"};

    private final int symbol;
    private int color;

    public Card(int symbol, int color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbolString() {
        return SYMBOLS[this.getSymbol()];
    }

    public boolean canBeFirstCard() {
        return getSymbol() < 10;
    }

    public boolean canPutCardOn(Card card) {
        return (card.getSymbol() == this.getSymbol()) || (card.getColor() == this.getColor()) || (this.getColor() == 0);
    }

    public boolean isSpecialCard() {
        return getSymbol() >= 10;
    }

    public void pickColour(Scanner scan) {
        if(this.getColor() != 0) return;

        System.out.println("\nPick a new colour:");
        for(int i = 1; i < Card.COLORS.length; i++)
            System.out.printf("\t--> %d, %s%n", i, Card.COLORS[i]);

        System.out.print("Enter the index of the color you want to pick: ");
        final String index = scan.next();

        if(Number.isInteger(index)) {
            final int num = Integer.parseInt(index);
            if(num < Card.COLORS.length && num >= 1) {
                this.setColor(num);
                return;
            }
        }
        System.out.println("--------------------------------------------------------\nVALUE (" + index + ") IS NOT A VALID NUMBER\n--------------------------------------------------------\n\n\n");
        pickColour(scan);
    }

    public Card normalize() {
        if(this.getSymbol() >= 13) this.setColor(0);
        return this;
    }

    @Override

    public String toString() {
        return color == 0 ? getSymbolString() : getColorString() + " " + getSymbolString();
    }

    public String getColorString() {
        return COLORS[this.getColor()];
    }

    public int getSymbol() {
        return symbol;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
