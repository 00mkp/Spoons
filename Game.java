/* A class representing a spoons card Game. Holds member variables for players of type Player array,
 * a Dealer, and an integer representation of the number of spoons in the game.
 */

import java.util.LinkedList;
import java.util.Random;

public class Game {
    private Player[] players;
    private Dealer dealer;
    public static int nSpoons;

    /* Default constructor creates a game with four players and 3 spoons. */
    public Game() {
        nSpoons = 3;

        this.dealer = new Dealer();

        this.players = new Player[4];

        for(int i = 0; i < players.length; i++) {
            this.players[i] = new Player((i + 1), this.dealer);
        }
    }

    /* Overloaded constructor takes in an integer representation of the 
     * number of players in a game and creates a game with that many Player objects
     * and one less spoon.
     */
    public Game(int numPlayers) {
        nSpoons = numPlayers - 1;

        this.dealer = new Dealer();

        players = new Player[numPlayers];

        for(int i = 0; i < players.length; i++) {
            this.players[i] = new Player((i + 1), this.dealer);
        }
    }

    /* play method runs the game and returns the number of the losing Player.  */
    public int play() {
        this.dealer = new Dealer();
        
        while(nSpoons > 0) {
            LinkedList<Card> discardPile = new LinkedList<Card>(); //start a discard pile
            
            Card passed = new Card(); //instantiate card 

            LinkedList<Card> startHand = this.dealer.deals(1); //start with one card from same dealer deck

            Card start = startHand.get(0); //that card above

            for(int i = 0; i < players.length; i++) {
                if(dealer.size() == 0) { //set dealers deck to discard pile if no cards left
                    Deck discard = new Deck(discardPile);
                    this.dealer.discarded(discard);
                }
                
                if(i == 0) { //if first player, take dealer card
                    passed = players[i].takeTurn(start);
                }

                passed = players[i].takeTurn(passed); //if not, take passed card

                if(i == (players.length - 1)) {
                    discardPile.add(passed); //if last player in circle, add card to discard
                }

                if(nSpoons < (players.length - 1)) { //if spoon stolen, give others chance of taking spoon
                    Random randy = new Random();
                    int rand = randy.nextInt(3);
                    int randPlayer = randy.nextInt(players.length);

                    if(rand == 0) {
                        players[randPlayer].stealSpoon();
                    }
                }
            }
        }

        for(Player p : players) {
            if(p.hasSpoon() == false) {
                return p.getPlayerNum(); //check which player doesnt have spoon
            }
        }

        return -1; //catch all
    }

    /* Accessor method for the Players in the Game */
    public Player[] getPlayers() {
        return this.players;
    }

    /* Accessor method for the Dealer of the game. */
    public Dealer getDealer() {
        return this.dealer;
    }

    /* Accessor method for the number of spoons in the Game. */
    public int getSpoons() {
        return nSpoons;
    }
}