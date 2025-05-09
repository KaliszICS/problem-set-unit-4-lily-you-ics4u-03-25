/**
 * This Deck class allows users to create a deck of playing cards.
 * It provides methods to access the size of the deck, manipulate the deck by drawing cards, shuffling and reshuffling the deck.
 * @author Lily You
 * @version 1.4
 */

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Deck{
    private ArrayList<Card> deck;

    /**
     * Constructs a new Deck object with the variable cards
     * @param cards Card array - represents the deck of cards
     */
    public Deck(Card[] cards){
        if(cards == null){
            this.deck = new ArrayList<>();
        }
        else{
            this.deck = new ArrayList<>(Arrays.asList(cards));
        }
    }
    
    /**
     * Constructs a new Deck object that generates an unshuffled deck of cards
     */
    public Deck(){
        this.deck = new ArrayList<>();
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for(int i = 0; i < suits.length; i++){
            for(int j = 0; j < names.length; j++){
                this.deck.add(new Card(names[j], suits[i], values[j]));
            }
        }
    }


    /**
     * This method returns the amount of cards in the deck
     * @return the amount of cards in the deck
     */
    public int size(){
        if(this.deck == null){
            return 0;
        }
        return this.deck.size();
    }

    /**
     * This method removes the top card from the deck and returns it
     * @return the top card of the deck
     */
    public Card draw(){
        if(this.deck == null || this.deck.isEmpty()){
            return null;
        }
        return this.deck.remove(this.deck.size()-1);
    }
    
    /*Source: https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
    I used it to help me with how to loop through without repeats or losing elements
    Use random(https://www.geeksforgeeks.org/generating-random-numbers-in-java/) and swap elements in the array to shuffle it */ 
    /**
     * This method shuffles the cards in the deck by swapping elements
     */
    public void shuffle(){
        if(this.deck != null){
            Random num = new Random();
            for(int i = this.deck.size() - 1; i > 0; i--){
                int index = num.nextInt(i+1);
                Card temp = this.deck.get(i);
                this.deck.set(i, this.deck.get(index));
                this.deck.set(index, temp);
            }
        }
    }

    /**
     * This method adds the provided Card object into the deck
     * @param card the Card object to be added to the deck
     */
    public void addCard(Card card){
        if(card != null){
            this.deck.add(card);
        }
    }
    
    /**
     * This mehod adds an array of cards into the deck and shuffles it
     * @param cards Card array that contains the cards that are to be added
     */
    public void reshuffle(Card[] cards){
        if(cards != null && cards.length > 0){
            for(int i = 0; i < cards.length; i++){
                this.deck.add(cards[i]);
            }
        }
        shuffle();
    }
}