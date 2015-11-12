import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TrainCard {
	
    private int colour;
    //0 : joker/locomotive
    //1 : purple
    //2 : white
    //3 : blue
    //4 : yellow
    //5 : orange
    //6 : black
    //7 : red
    //8 : green
    
    //Arraylists for different decks and card placements
    private ArrayList<TrainCard> deck = new ArrayList();
    private ArrayList<TrainCard> graveyard = new ArrayList();
    private ArrayList<TrainCard> shown = new ArrayList();

    //A single traincard cannot be made, call method makeDeck()
    private TrainCard(int colour) {
        this.colour = colour;
    }

    //Method for creating an entire deck
    ArrayList<TrainCard> makeDeck() {
        for (int i = 0; i < 110; ++i) {
            if (i < 14) {
                this.deck.add(new TrainCard(0));
                continue;
            }
            if (14 <= i && i < 26) {
                this.deck.add(new TrainCard(1));
                continue;
            }
            if (26 <= i && i < 38) {
                this.deck.add(new TrainCard(2));
                continue;
            }
            if (38 <= i && i < 50) {
                this.deck.add(new TrainCard(3));
                continue;
            }
            if (50 <= i && i < 62) {
                this.deck.add(new TrainCard(4));
                continue;
            }
            if (62 <= i && i < 74) {
                this.deck.add(new TrainCard(5));
                continue;
            }
            if (74 <= i && i < 86) {
                this.deck.add(new TrainCard(6));
                continue;
            }
            if (86 <= i && i < 98) {
                this.deck.add(new TrainCard(7));
                continue;
            }
            if (98 > i || i >= 110) continue;
            this.deck.add(new TrainCard(8));
        }
        System.out.println("Deck of cards created");
        return this.deck;
    }

    //Method for shuffling the array (any size usable)
    ArrayList<TrainCard> shuffleDeck(ArrayList<TrainCard> _deck) {
        long seed = System.nanoTime();
        Collections.shuffle(_deck, new Random(seed));
        return _deck;
    }

    //Method for putting the first deck card into grave
    void cardToGrave(ArrayList<TrainCard> _deck) {
        this.graveyard.add(this.deck.get(0));
        this.deck.remove(0);
        this.deck.trimToSize();
    }

    //Method for taking all cards from grave and putting them to deck
    void cardFromGrave() {
        for (int i = 0; i < this.graveyard.size(); ++i) {
            this.deck.add(this.graveyard.get(i));
        }
        this.graveyard.removeAll(this.graveyard);
    }

    //Method handling the shown cards
    ArrayList<TrainCard> shownCards(ArrayList<TrainCard> _deck) {
        return _deck;
    }

    //Method handling the player hands
    ArrayList<TrainCard> cardsToHand(ArrayList<TrainCard> _deck) {
        return _deck;
    }
}