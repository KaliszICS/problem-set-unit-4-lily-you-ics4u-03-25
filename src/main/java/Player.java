/**
 * This Player class allows users to create and access the name and age of the player and the cards in their hand.
 * This class has methods that gets the amount of cards in hand, draws cards from the deck, discards cards to the discard pile, returns cards to the deck,
 * and also returns the player's information in a readable format.
 * 
 * @author Lily You
 * @version 1.4
 */

import java.util.Arrays;
import java.util.ArrayList;

public class Player{
    private ArrayList<Card> hand;
    private String name;
    private int age;

    /**
     * Constructs a new Player object with the variables name, age and cards.
     * @param name String - the name of the player.
     * @param age int - the age of the player.
     * @param cards Card array - the array of cards representing the cards the players has in hand.
     */
    public Player(String name, int age, Card[] cards){
        this.name = name;
        this.age = age;
        if(cards == null){
            this.hand = new ArrayList<>(Arrays.asList(new Card[0]));
        }
        else{
            this.hand = new ArrayList<>(Arrays.asList(cards));
        }
    }

    /**
     * Constructs a new Player object with the variables name and age, and creates a default empty hand of cards.
     * @param name
     * @param age
     */
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>(Arrays.asList(new Card[0]));
    }

    /**
     * Gets the name of the player.
     * @return the name of the player as a String.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the age of the player.
     * @return the age of the player as an int.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Gets the cards in the player's hand.
     * @return the cards in the player's hand as an array of Cards.
     */
    public Card[] getHand(){
        return this.hand.toArray(new Card[this.hand.size()]); 
    }

    /**
     * This method returns the amount of cards the player has in hand.
     * @return the amount of cards in hand.
     */
    public int size(){
        if(this.hand == null){ 
            return 0;
        }
        return this.hand.size();
    }

    /**
     * This method takes a card from the provided Deck object and adds it to the player's hand.
     * @param deck the Deck object representing the deck that the card is drawn from.
     */
    public void draw(Deck deck){
        Card drawnCard = null;
        if(deck != null){
            drawnCard = deck.draw();
        }

        //Make sure a card was drawn in the first place
        if(drawnCard != null){
            this.hand.add(drawnCard);
        }
    }

    /**
     * This method removes the provided Card object from the player's hand and adds it to the provided discard pile.
     * @param card the Card object to be removed from the player's hand and added to the discard pile.
     * @param discardPile the DiscardPile object represeneting the discard pile the card will be added to.
     * @return true if the card exists and has successfully added to the discard pile and removed from the player's hand, otherwise false.
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        if(card == null || discardPile == null){
            return false;
        }

        if(this.hand.remove(card)){
            discardPile.addCard(card);
            return true;
        }

        return false;
    }

    /**
     * This method removes the provided Card object from the player's hand and adds it to the deck
     * @param card the Card object to be removed from the player's hand
     * @param deck the Deck object representing the deck that the card will be added to
     * @return true if the card exists and has successfully been returned to the deck and removed from the player's hand, otherwise false
     */
    public boolean returnCard(Card card, Deck deck){
        if(card == null || deck == null){
            return false;
        }

        if(this.hand.remove(card)){
            deck.addCard(card);
            return true;
        }
        
        return false;
    }

    /**
     * Returns the name, age and each card in the player's hand in a readable format
     * @return the name, age, and a list of each card in the player's hand as a String in the format "Player's name, age, Name of Suit, Name of Suit..."
     */
    @Override
    public String toString(){
        String info = this.name + ", " + this.age + ", ";
        for(int i = 0; i < this.hand.size(); i++){
            info += this.hand.get(i);
            if(i < this.hand.size()-1){
                info += ", ";
            }
        }
        info += ".";
        return info;
    }
}