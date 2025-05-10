public class ExampleClass {
    public static void main(String[] args){
        // do we need to use hash code with equals() method
        //make sure that it does mean what version of my java file not yea
        Card card1 = new Card("Queen", "Diamonds", 12);
        Card cardCopy = new Card("Queen", "Diamonds", 12);
        Card card2 = new Card("2", "Spades", 2);
        Card card3 = new Card("Jack", "Clubs", 11);
        Card card4 = new Card("King", "Hearts", 13);
        Card card5 = new Card("4", "Hearts", 4);
        Card nullCard = new Card(null, "Diamond", 0);
        Card emptyCard = new Card("", "", 4);
        Card nullCopyCard = new Card(null, null, 0);

        //Card class
        System.out.println("Card: " + card1); //Card: Queen of Diamonds
        System.out.println("Null Card: " + nullCard); //Null Card: null of null
        System.out.println("Empty Card: " + emptyCard); //Empty Card:   of    
        System.out.println(card1.equals(cardCopy)); //true
        System.out.println(card1.equals(card2)); //false
        System.out.println(card1.equals(nullCard)); //false
        System.out.println(emptyCard.equals(null)); //false
        

        Card[] cards = {card1, card3, card2, card3};
        Card[] cards2 = {};
        Card[] cards3 = {card2, card3, null, card1};
        Deck myDeck = new Deck(cards);
        Deck nullDeck = new Deck(cards2);
        Deck withNullDeck = new Deck(cards3);
        Deck fullDeck = new Deck();

        myDeck.addCard(null);
        myDeck.addCard(card3);
        myDeck.addCard(card4);

        System.out.println(myDeck); //print my own created deck
        System.out.println(nullDeck); //print nothing
        System.out.println(fullDeck); //print entire/default deck
        

        //check card size
        System.out.println(myDeck.size()); //6
        System.out.println(nullDeck.size()); //0
        System.out.println(fullDeck.size()); //52

        fullDeck.shuffle();
        System.out.println(fullDeck);
        System.out.println(" ");

        myDeck.shuffle();
        System.out.println(myDeck);
        System.out.println(" ");

        nullDeck.shuffle();
        System.out.println(nullDeck);
        System.out.println(" ");

        myDeck.reshuffle(null);
        System.out.println(myDeck);
        System.out.println(" ");

        fullDeck.reshuffle(cards);
        System.out.println(fullDeck);
        System.out.println(" ");

        nullDeck.reshuffle(null);
        System.out.println(nullDeck);
        System.out.println(" ");

        //addCard, shuffle and reshuffle method good

        //draw method is working
        System.out.println(myDeck.draw());
        System.out.println(myDeck);
        System.out.println(nullDeck.draw());
        System.out.println(nullDeck);
        System.out.println(fullDeck.draw());
        System.out.println(fullDeck);

        DiscardPile myyDeck = new DiscardPile(cards);
        DiscardPile myyyDeck = new DiscardPile(cards);
        DiscardPile emptyDiscardPile = new DiscardPile();

        System.out.println("Discard Pile");
        myyDeck.addCard(card4);
        System.out.println(myyDeck);
        System.out.println(myyDeck.getDiscardPile()); 
        System.out.println(myyDeck.removeCard(card3)); //Jack of Clubs + check if removed
        System.out.println(myyDeck);
        System.out.println(myyDeck.removeCard(card5)); //null
        System.out.println(myyDeck); //returns the same deck bc removes nothing
        System.out.println(myyDeck.removeAll());
        System.out.println("empty?" + myyDeck); //empty

        System.out.println("Empty Discard Pile: " + emptyDiscardPile);


        System.out.println("Player Class");

        Card[] mine = {card3, card2, card5, card5, card2};
        Player me = new Player("Lily", 24, mine);
        Player me2 = new Player("Lily", 22);
        System.out.println(me.getHand()); //reference to memory

        System.out.println(me.size()); //5
        System.out.println(me2.size()); //0

        System.out.println("");
        System.out.println(myDeck);
        me.draw(myDeck);
        me2.draw(null); //drawing null from deck
        System.out.println(myDeck); //check if removed card
        System.out.println(me); //check if added
        System.out.println(me2); //check if added
        me.draw(nullDeck); //empty deck
        System.out.println("empty" + nullDeck);
        System.out.println(me);

        System.out.println("");
        System.out.println(myyyDeck);
        System.out.println(me.discardCard(card5, myyyDeck)); //true
        System.out.println(me.discardCard(null, myyyDeck)); //false
        System.out.println(me); //check if removed from hand
        System.out.println(myyyDeck); //check if added

        System.out.println("");
        System.out.println(myDeck);
        System.out.println(me.returnCard(card3, myDeck)); //true
        System.out.println(me); //check if removed from hand
        System.out.println(myDeck); //check if added to deck
        System.out.println(me.returnCard(null, null));
        System.out.println(me); //no change
        System.out.println(me.returnCard(null, withNullDeck));


    }
}