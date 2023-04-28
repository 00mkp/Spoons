/* This class is a representation of a Deck consisting of 52 Card
 * objects, where a Deck is created and populated with Cards of every
 * standard value. Has member variables for a Deck of type LinkedList<Card>.
 */

import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private LinkedList<Card> m_cards;

    /* Default constructor creates a new Deck with all
     * 52 standard Cards.
     */
    public Deck() {
        this.m_cards = new LinkedList<Card>();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                this.m_cards.add(new Card(j, i));
            }
        }
    }

    /* Copy constructor takes in a paramter of type Deck and creates 
     * a new Deck with the same exact Cards in it as the passed Deck
     */ 
    public Deck(Deck deckToCopy) {
        this.m_cards = new LinkedList<Card>();
        
        for (int i = 0; i < deckToCopy.m_cards.size(); i++) {
            this.m_cards.add(new Card(deckToCopy.m_cards.get(i)));
        }
    }

    public Deck(LinkedList<Card> discarded) {
        this.m_cards = discarded;
    }

    /* size method that returns the integer representation of the 
     * number of Cards in the Deck.
     */
    public int size() {
        return this.m_cards.size();
    }

    /* deal method removes and returns a random Card from the deck,
     * returning a value of type Card.
     */
    public Card deal() {
        Random randy = new Random();

        int toDeal = randy.nextInt(this.m_cards.size());
        Card dealt = this.m_cards.get(toDeal);

        this.m_cards.remove(toDeal);

        return dealt;
    }

    /* toString method that returns the string representation of 
     * the Deck of Cards, printing every Card on its own line.
     */
    public String toString() {
        String prettyPrint = "";
        
        for (int i = 0; i < this.m_cards.size(); i++) {
            prettyPrint += this.m_cards.get(i) + "\n";
        }

        return prettyPrint;
    }
}