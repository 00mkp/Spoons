/* This class is a representation of a Card within a Deck
 * where Cards are created and initialized within a Deck object. Holds
 * member variables for value (type int) and suit (type int)
 */

public class Card {
    /* Integer representations of suits */
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    /* Integer representations of face card values */
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    private int value;
    private int suit;

    // Default constructor creates an Ace of Spades
    public Card() {
        this.value = ACE;
        this.suit = SPADES;
    }

    /* Overloaded constructor takes in passed values for 
     * suit and value and creates a card with those values for value
     * and suit.
     */
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }
    
    /* Copy constructor takes in an Object of type Card and copies
     * the suit and value over to the new Card.
    */
    public Card(Card cardToCopy) {
        this.value = cardToCopy.value;
        this.suit = cardToCopy.suit;
    }

    /* Accessor method for the suit of a Card, returning an integer representation of the suit.
     */
    public int getSuit() {
        return this.suit;
    }

    /* Accessor method for the value of a card, returning a String
     * representation of the integer representation of the value of 
     * a Card.
     */
    public int getValue() {
        return this.value;
    }

    /* Mutator method for the suit of a Card, accepting a parameter
     * of type int and setting the suit of that Card to the passed 
     * value.
     */
    public void setSuit(int newSuit) {
        this.suit = newSuit;
    }

    /* Mutator method for the value of a Card, accepting a parameter
     * of type int and setting the value of that Card to the passed 
     * value.
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }

    /* Equals method representing the equality of two Cards. Two
     * Cards are equal if their values, not suits, are equal. Accepts
     * paramter of type Object and returns a boolean value
     * represnting the equality of the Cards.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        } else {
            Card other = (Card) o;
            return (this.value == other.value);
        }
    }

    /* toString method returns the String represenetation of a Card,
     * converting the integer representations to Strings.
    */
    public String toString() {
        String faceName;
        String suitName;
        
        switch (this.value) {
            case 11: faceName = "Jack";
                break;
            case 12: faceName = "Queen";
                break;
            case 13:  faceName = "King";
                break;
            case 14: faceName = "Ace";
                break;
            default: faceName = String.valueOf(this.value);
        }

        switch (this.suit) {
            case 0: suitName = "Hearts";
                break;
            case 1: suitName = "Spades";
                break;
            case 2: suitName = "Clubs";
                break;
            case 3: suitName = "Diamonds";
                break;
            default: suitName = "somethings wrong";
                break;
        }

        return faceName + " of " + suitName;
    }
}