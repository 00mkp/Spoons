/* This class represents a Player object in a Spoons game that can take turns. Holds
 * member variables for the integer representation of the Player number, a LinkedList<Card>
 * representation of the Player hand, and a boolean member variable representing the posession
 * of a spoon.
 */

import java.util.LinkedList;
import java.util.*;

public class Player {
    private int playerNum;
    private LinkedList<Card> hand;
    private boolean hasSpoon;

    /* Constructor creating a player without a spoon, a hand from an assigned dealer, and 
     * with a passed player number.
     */
    public Player(int playerNum, Dealer dealer) {
        this.playerNum = playerNum;
        this.hand = dealer.deals(4);
        this.hasSpoon = false;
    }

    /* Constructor that creates a Player with a number, no spoon, and a user specified hand. */
    public Player(int playerNum, LinkedList<Card> hand) {
        this.playerNum = playerNum;
        this.hand = hand;
        this.hasSpoon = false;
    }

    /* takeTurn method that takes in a Card representing the card passed to them. If the 
     * Player obtains four of a kind of Card, a spoon is stolen. If not, the Player will pass
     * a card that does not match other cards in their hand.
     */
    public Card takeTurn(Card passedCard) {
        Card cardToPass = passedCard;
        this.hand.add(passedCard); // add the recieved card to hand to compare
        LinkedList<Card> currMatches = checkMatches(); //assign linked list of shortest length (least matches)
        
        for (Card c : this.hand) { // check for four spoons
            int t = 0;
            for (Card d : this.hand) {
                if(c.equals(d)) {
                    t += 1;
                }
            }
            if(t == 4) {
                stealSpoon();
                break;
            }
        }
        
        for(Card c : this.hand) { //figure out which card to pass
            if(currMatches.contains(c)) { //if the card in the hand is in the list of least matches 
                cardToPass = c;
                this.hand.remove(cardToPass);
                break;
            }
        }

        return cardToPass;
    }

    /* stealSpoon method that sets the Players spoon status to true and removes one
     * spoon from the game.
     */
    public void stealSpoon() {
        this.hasSpoon = true;
        
        Game.nSpoons -= 1;
    }

    /* checkMatches method that takes the Player hand and returns a LinkedList<Card> 
     * with matching cards in it. 
     */
    public LinkedList<Card> checkMatches() {
        HashMap<Integer, LinkedList<Card>> matches = new HashMap<Integer, LinkedList<Card>>();
        int min = 1000;
 
        for(int i = 2; i < 15; i++) { //hashmap with every card value and a linked list for that value 
            matches.put(Integer.valueOf(i), new LinkedList<Card>());
        }

        for(Integer i : matches.keySet()) { //populate linked lists with cards of that value 
            for(Card c : this.hand) {
                if(c.getValue() == i) {
                    matches.get(i).add(c);
                }
            }
        }

        for(LinkedList<Card> ll : matches.values()) { //set least match list length
            if((ll.size() < min) && (ll.size() > 0)) { //make sure theres something in it
                min = ll.size();
            }
        }

        for(Integer i : matches.keySet()) {
            if(matches.get(i).size() == min) {
                return matches.get(i); //return list with least matches 
            }
        }

        return new LinkedList<Card>();
    }

    /* Accessor method for the Player number */
    public int getPlayerNum() {
        return this.playerNum;
    }
    /* Accessor method for the Player hand */
    public LinkedList<Card> getHand() {
        return this.hand;
    }

    /* Accessor method for the Player spoon status */
    public boolean hasSpoon() {
        return this.hasSpoon;
    }

    /* toString method returning the String representation of a Player with their number. */
    public String toString() {
        return "Player" + this.playerNum;
    }
}