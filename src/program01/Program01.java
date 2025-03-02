package program01;

import java.util.Random;

public class Program01 {
		
		public static void initDeck(boolean[] deck) {
			// set the values of deck to indicate that they are all
			// present - not dealt yet.
			for (int i = 0; i < deck.length; i++) {
				deck[i]= true;
			}
		}

		public static boolean emptyDeck(boolean[] deck) {
			// returns whether or not all the cards in the deck
			// have already been dealt.
			for (boolean card : deck) {
            			if(!card) {
                			return false;
            			}
       			}
       			return true;
		}
		
		public static int dealCard(boolean[] deck) {
			// returns a card (an int in the range 0 to 51) at random
			// that has not been dealt since the deck was initialize
			// via intDeck. Also notes (in deck) that this card is
			// no longer available.
			Random random = new Random();
			
			int cardIndex;
			
			do {
				cardIndex = random.nextInt(52);
			}
			while (!deck[cardIndex]);
			
			deck[cardIndex] = false;
		
			return cardIndex;
			
		}

		public static void printCard(int card) {
			// given a card (an int in the range 0 to 51) prints
			// an appropriate representation of this card based
			// on a 1-1 and onto mapping of the set [0, 51] to
			// the cards described above.
			String[] suits = {"C", "S", "H", "D"};
        		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

       			int rankIndex = card % 13;
       			int suitIndex = card / 13;
        		System.out.print(ranks[rankIndex] + suits[suitIndex]);
		}
		
		public static void main(String[] args) {
			
		boolean[] myDeck = new boolean[52];
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		
		initDeck(myDeck);
		
		System.out.println("\nHere is a shuffled deck ...\n");
		
		while (!emptyDeck(myDeck)) {
			myCard = dealCard(myDeck);
			++cardsThisRow;
			if (cardsThisRow <= cardsPerRow) {
				printCard(myCard);
				System.out.print(" ");
				}
			else {
				System.out.println("");
				cardsThisRow = 1;
				printCard(myCard);
				System.out.print(" "); 
				}
			}
		System.out.println("\n");
	}
}
