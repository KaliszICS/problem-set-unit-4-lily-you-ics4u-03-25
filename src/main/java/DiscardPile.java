/**
 * This DiscardPile class allows users to create and access a discard pile of cards.
 * It provides methods 
 * @author Lily You
 * @version 1.4
 */
import java.util.Arrays;
import java.util.ArrayList;
public class DiscardPile{
    private ArrayList<Card> discardPile;

    /**
     * Constructs a new DiscardPile object with the variable cards
     * @param cards Card array - represents a deck of cards
     */
    public DiscardPile(Card[] cards){
        if(cards == null){
            this.discardPile = new ArrayList<>();
        }
        else{
            this.discardPile = new ArrayList<>(Arrays.asList(cards));
        }
    }

    /**
     * Constructs a new DiscardPile object that creates an empty array representing an empty discard pile
     */
    public DiscardPile(){
        this.discardPile = new ArrayList<>();
    }

    /**
     * Gets the discard pile
     * @return the discard pile as an array of cards
     */
    public Card[] getDiscardPile(){
        return this.discardPile.toArray(new Card[this.discardPile.size()]);
    }

    /**
     * This method returns the amount of cards in the discard pile
     * @return the amount of cards in the discard piel as an int
     */
    public int size(){
        if(this.discardPile == null){ 
            return 0;
        }
        return this.discardPile.size();
    }

    /**
     * This method adds the provided Card object to the top of the discard pile
     * @param card the Card object to be added into the discard pile
     */
    public void addCard(Card card){
        if(card != null){
            this.discardPile.add(card);
        }
    }

    /**
     * This method removes the provided Card object from the discard pile and returns the removed card
     * @param card the Card object to be removed from the discard pile
     * @return the first occurence of the removed card as a Card object, if the card does not exist, it returns null
     */
    public Card removeCard(Card card){
        if(card != null && this.discardPile.contains(card)){
            this.discardPile.remove(card);
            return card;
        }

       return null;
    }

    /**
     * This method returns the discard pile and removes all cards from the discard pile
     * @return the discard pile as an array of cards before emptying it
     */
    public Card[] removeAll(){
        if(this.discardPile == null || this.discardPile.size() == 0){
            return new Card[0];
        }

        Card[] originalDiscardPile = this.discardPile.toArray(new Card[this.discardPile.size()]);
        this.discardPile.clear();
        return originalDiscardPile;
    }

    /**
     * Returns each card in the discard pile in a readable format
     * @return a list of each card in the discard pile as a String in the format "Name of Suit, Name of Suit, Name of Suit..."
     */
    @Override
    public String toString(){
        String allCards = "";
        for(int i = 0; i < this.discardPile.size(); i++){
            allCards += this.discardPile.get(i);
            if(i < this.discardPile.size()-1){
                allCards += ", ";
            }
        }
        allCards += ".";
        return allCards;
    }
}