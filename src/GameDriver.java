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
      // variables / declaration
      // we are going to need user input so make a scanner object, declare intent to create a deck object, dealer, and player hand objects
      // create int for # of decks parameter, set it equal to 6 because the assignment asks us to
      //create a int sum variable to store the sum of the hands, create 2 booleans 1 for our loop and 1 for our printHand method
      //create strings to take the value of the print hand method and user inputs, lastly create a double for money and set it = 1000
      
      Scanner myScanner = new Scanner(System.in);
      Deck myDeck;
      int numberOfDecks = 6;
      int playerSum;
      double money = 1000.0;
      Hand playerHand, dealerHand;
      boolean isDealer;
      boolean isPlayerHitting = true;
      String printedHand, userChoice, anotherGame;
      
      //Create and shuffle deck using our deck constructor and shuffle method
      //keep outside of loop so we can keep playing from the same deck in separate games
		
      System.out.println("Creating deck of 52 * " + numberOfDecks + " cards...");
      myDeck = new Deck(numberOfDecks);
      System.out.println("Shuffling Deck...");
      myDeck.shuffle();
         
      //put the entire game process inside a do-while loop as we will be playing at least one time
      //check if money < 200 as this is our minimum to play, if less print that and then leave the loop
		
      do
      {
         if (money < 200)
         {
            System.out.println("Not enough $$$ to play!");
            break;
         }
         
         //deduct the 200$ bet from user upfront
         money -= 200;
                         

         //create a hand for the player and one for the dealer using our Hand constructor so they will be refreshed every single game
			
         playerHand = new Hand();
         dealerHand = new Hand();

         // Deal starting cards (2 each) to player and dealer 
			
         System.out.println("Giving you and the dealer your initial cards...");
         playerHand.addCard(myDeck.dealCard());
         dealerHand.addCard(myDeck.dealCard());
         playerHand.addCard(myDeck.dealCard());
         dealerHand.addCard(myDeck.dealCard());

         // Display player's hand after cards given
         // set the player sum variable = playerHand object with . sumHand method
         //set printed Hand = playerHand object with .printHand method, we will give .printHand false to indicate it's not the dealer
         //print these variables to screen for user to see
			
         playerSum = playerHand.sumHand();
         printedHand = playerHand.printHand(false);

         System.out.println("Your hand is currently of the total value: " + playerSum + "\nYou have: " + playerHand.getNumOfCards() + " cards\nYour cards are: " + printedHand);
         
         //check if game was ended with only 2 cards;
         //Did dealer get sum 21 in 2 cards? if so don't return bet, print new balance
         //Did player win with 21 in two cards? return bet and times their bet + bet * 1.5, print new balance
         //Did both dealer and player get 21 in initial 2 cards? Return bet to player and display new balance
         if (dealerHand.sumHand() == 21)
         {
            System.out.println("You Lose! Dealer has hit 21 before you, bet has been lost");
            printDealerHand(dealerHand);
            System.out.println("New Balance: " + money);
         }
         else if (playerHand.sumHand() == 21)
         {
            System.out.println("You Win! You have hit 21 on your first 2 cards! You win an extra $100 totalling to $300.");
            printDealerHand(dealerHand);
            money += 500;
            System.out.println("New Balance: " + money);
         }
         else if (dealerHand.sumHand() == 21 && playerHand.sumHand() == 21)
         {
            System.out.println("A tie/push! You and the Dealer have both hit 21. Your bet is returned");
            printDealerHand(dealerHand);
            System.out.println("New Balance: " + money);
         }
         
         //else if game hasn't been auto-ended after initial cards given out tell the user the dealer's face-up card
         //prompt them to hit (draw another card from deck into their hand) or stay (test their current handSum value against the dealers)
         //they must choose to hit or stay atleast once so its a do while loop
         //set user choice variable = to their input, make it non case sensitive or convert to lower case before equating it
			
         else
         {
            System.out.println("Dealer's face-up card: " + dealerHand.getCard(0).toString());
            
            //we need the dealer to draw until his hand sum is greater than or equal to 17, we can handle this before the players
            //make a loop for the dealer to draw cards until the condition dealerHand object . sumHand method is >= 17 is met
            
            while (dealerHand.sumHand() < 17)
            {
               dealerHand.addCard(myDeck.dealCard());
            }

            do{
               System.out.println("Hit or Stay");
               userChoice = myScanner.nextLine();
               userChoice = userChoice.toLowerCase();
               
               //if user selects hit, add another card to their playerHand object using our methods
               //if they do not select hit then we can set the loop conditon to false and exit the loop!
               //print the card they drew and the new sum value of their hand to the screen
					
               if (userChoice.equals("hit"))
               {
                  playerHand.addCard(myDeck.dealCard());
                  System.out.println("You drew: " + playerHand.getCard(playerHand.getNumOfCards() - 1).toString());
                  playerSum = playerHand.sumHand();
                  System.out.println("Your hand is currently of the value: " + playerSum);
                  
                  //if player hand sum >= 21 after drawing a new card set the loop boolean to false so we can exit and calculate results
						
                  if (playerHand.sumHand() >= 21)
                  {
                     isPlayerHitting = false;
                  }
                  
                  //if hand sum doesn't equal or exceed 21 continue the loop to ask them to hit or stay again
						
                  else
                  {
                     isPlayerHitting = true;
                  }
               }
               else
               {
                  isPlayerHitting = false;
               }
            } while (isPlayerHitting == true); // End of do-while loop for the player's turn

            // After the loop, compare the hands and determine the winner
				
				
				//check if player hand is less than or equal 21 and greater dealer, Win
				//return bet + winnings (400 dollars)
				//print new balance
				
            if (playerHand.sumHand() <= 21 && playerHand.sumHand() > dealerHand.sumHand()) 
            {
               System.out.println("You won! Your bet has been returned with an additonal $200 won.");
               printDealerHand(dealerHand);
               money += 400;
               System.out.println("New Balance: " + money);               
            }
            
				//check if player hand is a bust (>21) and dealer hand is not >21, Lose 				
				//don't return money. do nothing to balance as we already took the money initially
				//print new balance
				
            else if (playerHand.sumHand() > 21 && dealerHand.sumHand() <21) 
            {
               System.out.println("You busted! Your hand value was greater than 21, Your bet has been lost.");
               printDealerHand(dealerHand);
               System.out.println("New Balance: " + money); 
            } 
            
				//check if player hand is a bust (>21) and dealer hand is also a bust (>21), Tie 				
				//return bet money (200) to money var because we intially took it
				//print new balance
				
            else if (playerHand.sumHand() > 21 && dealerHand.sumHand() > 21) 
            {
               System.out.println("You both busted! both hands exceed 21 Your bet has been returned.");
               printDealerHand(dealerHand);
					money += 200;
               System.out.println("New Balance: " + money); 
            }
				
				//check if player hand is <21, and if player hand equal to dealer hand, Tie				
				//return bet money (200) to money var because we intially took it
				//print new balance
				
				else if (playerHand.sumHand() > 21 && playerHand.sumHand() == dealerHand.sumHand()) 
            {
               System.out.println("You Tied! Dealers hand was the same yours, Your bet has been returned.");
               printDealerHand(dealerHand);
					money += 200;
               System.out.println("New Balance: " + money); 
            }
				
				//else if none of those conditions were met we just plain lose without busting				
				//don't return money. do nothing to balance as we already took the money initially
				//print new balance
				
            else
            {
               System.out.println("You Lost! Dealers hand was closer to 21 than yours, Your bet has been lost.");
               printDealerHand(dealerHand);
               System.out.println("New Balance: " + money); 
            }
            
         } 
         
			//prompt the user to continue the game loop
			//take their input and determine to reloop or not
			
         System.out.println("Would you like to play again? (y/n)");
         anotherGame = myScanner.nextLine();

      } while (anotherGame.equalsIgnoreCase("y"));

      //Output Final money summary once game ends so user can see their changes and progress
		
      System.out.println("Money Summary;\nYou started with $1000.00 and went to $" + money);
      if (money < 1000) 
      {
         System.out.println("You lost a total of $" + (1000 - money));
      } 
      
      else 
      {
         System.out.println("You won a total of $" + (1000 - money));
      }
   } // end of main method

   // Helper method to print dealer's hand to make my code much less repetitive
   //just printing to screen using our created sum hand and print hand methods
	
   private static void printDealerHand(Hand dealerHand) {
      System.out.println("Dealer's total was: " + dealerHand.sumHand());
      System.out.println("Dealer's cards were: " + dealerHand.printHand(true));
   }
} // End of class
