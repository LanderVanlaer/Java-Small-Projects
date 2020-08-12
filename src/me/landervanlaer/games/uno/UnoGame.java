package me.landervanlaer.games.uno;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A full Uno game, played in the console
 *
 * @author LanderVanlaer
 * @version 1.0 2020/08/12
 * @since null
 */
public class UnoGame {
    /**
     * The whole deck on the table
     *
     * @see Card
     */
    private Deck deck = new Deck();

    /**
     * All the players in the current game
     *
     * @see Player
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * This tells who's turn it is in the game
     * <code>
     * whosTurn >= 0 && whosTurn < ({@link #players} length)
     * </code>
     *
     * @see #players
     * @since 1.0
     */
    private int whosTurn = 0;

    /**
     * tells how the direction is for the next person
     * <p>
     * if the value is {@code true}, then {@link #whosTurn} must add up.
     * If the value is {@code false}, then whosTurn must count down.
     *
     * @see #whosTurn
     */
    private boolean orderTurn = true;

    /**
     * Constructs an {@link UnoGame} where players are asked via the console
     *
     * @since 1.0
     */
    public UnoGame() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        String name = "";

        while(!name.equals("STOP")) {
            System.out.println("Give the name of the player\nIf you have filled in all the names, enter in \"STOP\"");
            System.out.print("Name: ");
            name = scan.next();
            if(!name.equalsIgnoreCase("STOP"))
                players.add(new Player(name));
        }
//        scan.close(); //COMMENTED BECAUSE OF ERROR
        this.setPlayers(players);
        this.startGame();
    }

    /**
     * construcs an {@link UnoGame} where the {@link #players} are given
     *
     * @param players All the {@link Player} objects in the game
     * @see #UnoGame()
     * @since 1.0
     */
    public UnoGame(ArrayList<Player> players) {
        this.setPlayers(players);
        this.startGame();
    }

    /**
     * Gives all the {@link #players} their start {@link Card}s
     * And starts the game
     *
     * @see Player#NUMBER_OF_CARDS_START
     * @see #players
     * @see Card
     * @see #nextTurn()
     */
    private void startGame() {
        this.getPlayers().forEach(player -> {
                    for(int i = 0; i < Player.NUMBER_OF_CARDS_START; i++)
                        player.getCards().add(getDeck().takeCard());
                }
        );
        nextTurn();
    }

    private void nextTurn() {
        System.out.printf("- - - - - - - - - - - - - - - - - -%n%s%n- - - - - - - - - - - - - - - - - -%n", getDeck().getCurrentCardOnTop().toString());

        if(getDeck().getCurrentCardOnTop().isSpecialCard()) {
            switch(getDeck().getCurrentCardOnTop().getSymbol()) {
                case 12 -> this.getCurrentPlayer().drawCardOfDeck(deck, 2);//DRAW 2
                case 14 -> this.getCurrentPlayer().drawCardOfDeck(deck, 4);//WILD DRAW 4
            }
        }

        final Card pickedCard = this.getCurrentPlayer().placeCard(this.getDeck());

        if(pickedCard != null) {
            this.getDeck().placeNewCard(pickedCard);

            if(getDeck().getCurrentCardOnTop().isSpecialCard()) {
                switch(getDeck().getCurrentCardOnTop().getSymbol()) {
                    case 10 -> this.nextPlayerIndex();//SKIP
                    case 11 -> this.reverseOrder();//REVERSE
                }
            }
        }
        nextPlayerIndex();
        nextTurn();
    }

    /**
     * Get the {@link Player} whose turn it is
     *
     * @return The player whose turn it currently is
     */
    private Player getCurrentPlayer() {
        return getPlayers().get(getWhosTurn());
    }

    private void nextPlayerIndex() {
        int newWhosTurn = getWhosTurn() + (isOrderTurn() ? 1 : -1);
        if(newWhosTurn < 0) newWhosTurn = getPlayers().size() - 1;
        if(newWhosTurn >= getPlayers().size()) newWhosTurn = 0;
        setWhosTurn(newWhosTurn);
    }

    public void reverseOrder() {
        this.setOrderTurn(!isOrderTurn());
    }

    public boolean isOrderTurn() {
        return orderTurn;
    }

    public void setOrderTurn(boolean orderTurn) {
        this.orderTurn = orderTurn;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getWhosTurn() {
        return whosTurn;
    }

    public void setWhosTurn(int whosTurn) {
        this.whosTurn = whosTurn;
    }

    public static void main(String[] args) {
        new UnoGame();
    }
}
