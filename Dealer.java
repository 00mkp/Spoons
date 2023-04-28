/* This class represents a Dealer that keeps track of a Deck object
 * that can deal Cards to players. Has member variables for the representation of 
 * the Deck the Dealer holds of type Deck.
 */

import java.util.LinkedList;

public class Dealer {
    private Deck m_deck;

    /* Default constructor that gives the dealer a new Deck of 
     * 52 Cards.
     */
    public Dealer() {
        this.m_deck = new Deck();
    }

    /* deals method that returns a Linked List of type Card and takes
     * in a parameter n of type int that represents the number of Cards
     * to be dealt.
     */
    public LinkedList<Card> deals(int n) {
        LinkedList<Card> handDealt = new LinkedList<Card>();

        if (!(this.m_deck.size() == 0)) {
            for (int i = 0; i < n; i++) {
                handDealt.add(this.m_deck.deal());
            }
        }

        return handDealt;
    }

    /* discarded method that sets the current deck of the dealer to a piled
     * of discarded cards to ensure that play continues with cards that have been discarded,
     * ensuring that cards in players hands are not put back into the game
     */
    public void discarded(Deck discards) {
        this.m_deck = discards;
    }

    /* size method that returns the number of Cards in the 
     * Dealers Deck as an integer.
     */
    public int size() {
        return this.m_deck.size();
    }

    /* toString method returns a String representation of a Deck,
     * using the toString method of the Deck object.
     */
    public String toString() {
        return this.m_deck.toString();
    }
}