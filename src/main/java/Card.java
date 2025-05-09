/**
 * This Card class allows users to access the name, suit and value of a playing card.
 * It also has methods that return the name and suit of the card in a readable format and compares if two cards are equal.
 * 
 * @author Lily You
 * @version 1.5
 */


public class Card{
    private String name;
    private String suit;
    private int value;

    /**
     * Constructs a new Card object with the variables name, suit and value
     * @param name String - the name of the card(Ex: 2, 3, 4, Queen, Jack, King)
     * @param suit String - the suit of the card(Ex: Spades, Diamonds, Clubs, Hearts)
     * @param value int - the value of the card that represents the hierarchy of the cards(Ex: 2, )
     */
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the name of the card
     * @return the name of the card as a String
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the suit of the card
     * @return the suit of the card as a String
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * Returns the value of the card
     * @return the value of the card as an int
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Returns the name and suit of the playing card in a readable format
     * @return name and suit of the card as a String in the format "Name of Suit"
     */
    @Override
    public String toString(){
        return this.name + " of " + this.suit;
    }

    /**
     * Checks if two cards are equal by comparing the name, suit and value of the cards
     * @param o the card given as an object to be compared with
     * @return true if the card has the same name, value and suit as this card, otherwise false
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Card thatCard = (Card)obj;
        
        return this.name.equals(thatCard.getName()) && this.suit.equals(thatCard.getSuit()) && this.value == thatCard.getValue();
    }
}