/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 *
 */
public class Hand extends GroupOfCards {

    public Hand() {
        super(0);
    }

    public void addCard(Card card) {
        getCards().add(card);
    }

    //this method calculates the value of the hand
    //it also counts how many aces are in the hand - at any point if the hand value goes over 21 but the hand contains an ace,
    //then ace is converted from a high value card to a low value card by subtracting 10, and decreasing the ace count. 
    public int calculateHandValue() {
        int value = 0; //total hand value 
        int aceCount = 0; //tracking how many aces in a hand 

        //for each card in the hand
        for (Card card : getCards()) {
            //if card is a StandardCard object 
            if (card instanceof StandardCard) {
                //assign to a variable stc
                StandardCard stc = (StandardCard) card;
                //value of the card's rank added to the value of the hand for each card 
                value += stc.getRank().getCardValue();
                // if it's an ace, add it to the ace counter
                if (stc.getRank() == Rank.ACE) {
                    aceCount++;
                }
            }
        }
        // while the hand value is over 21, and the ace counter is over 0
        while (value > 21 && aceCount > 0) {
            //remove 10 from the hand total to account for ace being equal to 1 or 11
            value -= 10;
            //then remove that ace from the ace counter
            aceCount--;
        }
        //return the total value of the hand 
        return value;
    }

    //check if the hand has gone over 21 
    public boolean isBusted() {
        return calculateHandValue() > 21;
    }

    //check if the hand is exactly 21 on initial deal 
    //hand size must be 2 and hand value must be exactly 21 
    public boolean isBlackjack() {
        return getCards().size() == 2 && calculateHandValue() == 21;
    }

    //clear the hand for a new round 
    public void clearHand() {
        getCards().clear();
    }

    @Override
    public String toString() {
        String result = "";
        for (Card card : getCards()) {
            result += card.toString() + ", ";
        }
        result += "Total Value: " + calculateHandValue();
        return result;
    }
}
