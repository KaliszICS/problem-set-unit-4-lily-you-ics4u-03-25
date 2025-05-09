/*public class ExampleClass {
    public static void main(String[] args){
        // do we need to use hash code with equals() method
        //make sure that it does mean what version of my java file not yea
        Card card1 = new Card("Queen", "Diamonds", 12);
        Card cardCopy = new Card("Queen", "Diamonds", 12);
        Card card2 = new Card("2", "Spades", 2);
        Card card3 = new Card("Jack", "Clubs", 11);
        Card card4 = new Card("King", "Hearts", 13);
        Card card5 = new Card("4", "Hearts", 4);
        Card nullCard = new Card(null, null, 0);
        Card emptyCard = new Card("", "", 4);
        Card null2Card = new Card(null, "Diamonds", 0);
        Card nullCopyCard = new Card(null, null, 0);

        //Card class
        System.out.println("Card: " + card1); //Card: Queen of Diamonds
        System.out.println("Null Card: " + nullCard); //Null Card: null of null
        System.out.println("Empty Card: " + emptyCard); //Empty Card:   of    
        System.out.println(card1.equals(cardCopy)); //true
        System.out.println(card1.equals(card2)); //false
        System.out.println(card1.equals(nullCard)); //false
        System.out.println(nullCard.equals(null2Card)); //false
        System.out.println(nullCard.equals(card1)); //false 
        System.out.println(nullCard.equals(nullCopyCard)); //true
        System.out.println(nullCopyCard.equals(nullCard)); //true
        

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
        System.out.println(me.discardCard(nullCard, myyyDeck)); //false
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
}*/

public class ExampleClass {
    public static void main(String[] args) {
        System.out.println("=== Testing Card Class ===");
        testCardClass();

        System.out.println("\n=== Testing Deck Class ===");
        testDeckClass();

        System.out.println("\n=== Testing DiscardPile Class ===");
        testDiscardPileClass();

        System.out.println("\n=== Testing Player Class ===");
        testPlayerClass();
    }

    private static void testCardClass() {
        // Test valid card creation
        Card validCard = new Card("Ace", "Hearts", 1);
        System.out.println("Valid card: " + validCard);

        // Test null name
        Card nullNameCard = new Card(null, "Spades", 2);
        System.out.println("Null name card: " + nullNameCard);

        // Test empty name
        Card emptyNameCard = new Card("", "Diamonds", 3);
        System.out.println("Empty name card: " + emptyNameCard);

        // Test null suit
        Card nullSuitCard = new Card("King", null, 13);
        System.out.println("Null suit card: " + nullSuitCard);

        // Test empty suit
        Card emptySuitCard = new Card("Queen", "", 12);
        System.out.println("Empty suit card: " + emptySuitCard);

        // Test card equality
        Card card1 = new Card("Ace", "Hearts", 1);
        Card card2 = new Card("Ace", "Hearts", 1);
        Card card3 = new Card("King", "Spades", 13);
        System.out.println("Card equality test: " + card1.equals(card2));
        System.out.println("Card inequality test: " + card1.equals(card3));
    }

    private static void testDeckClass() {
        // Test default deck creation
        Deck defaultDeck = new Deck();
        System.out.println("Default deck size: " + defaultDeck.size());

        // Test deck with null array
        Deck nullArrayDeck = new Deck((Card[]) null);
        System.out.println("Null array deck size: " + nullArrayDeck.size());

        // Test deck with array containing null cards
        Card[] cardsWithNull = {new Card("Ace", "Hearts", 0), null, new Card("King", "Spades", 0)};
        Deck deckWithNullCards = new Deck(cardsWithNull);
        System.out.println("Deck with null cards size: " + deckWithNullCards.size());

        // Test drawing from empty deck
        Deck emptyDeck = new Deck(new Card[0]);
        System.out.println("Draw from empty deck: " + emptyDeck.draw());

        // Test drawing from populated deck
        Deck populatedDeck = new Deck();
        System.out.println("Draw from populated deck: " + populatedDeck.draw());

        // Test shuffling
        Deck shuffledDeck = new Deck();
        System.out.println("Before shuffle - First card: " + shuffledDeck.draw());
        shuffledDeck = new Deck(); // Reset deck
        shuffledDeck.shuffle();
        System.out.println("After shuffle - First card: " + shuffledDeck.draw());
    }

    private static void testDiscardPileClass() {
        // Test empty discard pile
        DiscardPile emptyPile = new DiscardPile();
        System.out.println("Empty pile size: " + emptyPile.size());

        // Test pile with null array
        DiscardPile nullArrayPile = new DiscardPile((Card[]) null);
        System.out.println("Null array pile size: " + nullArrayPile.size());

        // Test adding null card
        DiscardPile pile = new DiscardPile();
        pile.addCard(null);
        System.out.println("Pile size after adding null: " + pile.size());

        // Test adding valid card
        Card card = new Card("Ace", "Hearts", 0);
        pile.addCard(card);
        System.out.println("Pile size after adding valid card: " + pile.size());

        // Test removing non-existent card
        Card nonExistentCard = new Card("King", "Spades", 0);
        System.out.println("Remove non-existent card: " + pile.removeCard(nonExistentCard));

        // Test removing existing card
        System.out.println("Remove existing card: " + pile.removeCard(card));

        // Test removeAll
        pile.addCard(new Card("Queen", "Diamonds", 0));
        pile.addCard(new Card("Jack", "Clubs", 0));
        Card[] removedCards = pile.removeAll();
        System.out.println("Number of cards removed: " + removedCards.length);
    }

    private static void testPlayerClass() {
        // Test player with null name
        Player nullNamePlayer = new Player(null, 20);
        System.out.println("Null name player: " + nullNamePlayer);

        // Test player with negative age
        Player negativeAgePlayer = new Player("John", -5);
        System.out.println("Negative age player: " + negativeAgePlayer);

        // Test player with null hand
        Player nullHandPlayer = new Player("Alice", 25, (Card[]) null);
        System.out.println("Null hand player: " + nullHandPlayer);

        // Test player with hand containing null cards
        Card[] cardsWithNull = {new Card("Ace", "Hearts", 0), null, new Card("King", "Spades", 0)};
        Player playerWithNullCards = new Player("Bob", 30, cardsWithNull);
        System.out.println("Player with null cards: " + playerWithNullCards);

        // Test drawing from null deck
        Player player = new Player("Test", 18);
        player.draw(null);
        System.out.println("Player hand after drawing from null deck: " + player);

        // Test drawing from empty deck
        Deck emptyDeck = new Deck(new Card[0]); // Create a truly empty deck
        player.draw(emptyDeck);
        System.out.println("Player hand after drawing from empty deck: " + player);

        // Test drawing from populated deck
        Deck populatedDeck = new Deck();
        player.draw(populatedDeck);
        System.out.println("Player hand after drawing from populated deck: " + player);

        // Test discarding non-existent card
        Card card1 = new Card("3", "Hearts", 4);
        DiscardPile discardPile = new DiscardPile();
        System.out.println("Discard non-existent card: " + player.discardCard(card1, discardPile));

        // Test returning card to null deck
        Card card2 = new Card("2", "Diamonds", 0);
        System.out.println("Return card to null deck: " + player.returnCard(card2, null));
    }
}

