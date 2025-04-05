/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author group 3
 *
 * this class extends group of cards. it creates a deck object with 52 cards,
 * where each card is unique
 */
public class Deck extends GroupOfCards {

    public static final int cardsPerDeck = 52;

    public Deck() {
        super(cardsPerDeck);
        populateDeck();
        shuffle();
    }

    private void populateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                getCards().add(new StandardCard(suit, rank));
            }
        }
    }

    public Card dealCard() {
        if (getCards().size() > 0) {
            return getCards().remove(0);
        }
        return null;
    }

    public void resetDeck() {
        getCards().clear();
        populateDeck();
        shuffle();
    }
}
