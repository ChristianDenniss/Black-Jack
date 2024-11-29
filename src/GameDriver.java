import java.util.Scanner;

/****************************************************************
* Black Jack Project Driver Class/ Play the game
*
* Christian Dennis
* 11/28/2024
* 0.0.1
******************************************************************/

public class GameDriver
{
   public static void main(String[] args)
   {
		//variables / declaration
		//we are going to need user input so make a scanner object, declare intent of a deck object
		//intialize a Hand object for both the player and dealer, create a int for number of decks parameter input
		//and boolean isDealer for our hand print method
		
      Scanner myScanner = new Scanner(System.in);
		Deck myDeck;
		Hand dealerHand = new Hand();
		Hand playerHand = new Hand();
		int numberOfDecks, playerSum, dealerSum;
		boolean isDealer;
		
		// Create a shuffled deck of cards consisting of 6 standard decks
		numberOfDecks = 6;
		myDeck = new Deck(numberOfDecks);
		
		//use shuffle method to make sure cards are shuffled, we can do this in the Deck class or manually here
		myDeck.shuffle();
		
		//Deal a card the players hand, a card to the dealers hand, a second card to both
		//Deal a card using our dealCard method add it to our player hand using 
		
		playerHand.addCard(myDeck.dealCard());
		dealerHand.addCard(myDeck.dealCard());
		playerHand.addCard(myDeck.dealCard());
		dealerHand.addCard(myDeck.dealCard());
		
		//display to the user the sum of their current hand using our sum hand method
		playerSum = dealerHand.sumHand();
		
		
		
   }
}
