import java.util.Random;

/****************************************************************
* Black Jack Deck Class
*
* Christian Dennis
* 11/28/2024
* 0.0.1
******************************************************************/

public class Deck
{
   //we are going to have 2 deck methods so make the Card array a instance class variable to use it in both
   //we also need to track where to put each card in each deck array so we need a integer for that
   private Card[] deck;
   
    /* 
      - DEFAULT CONSTRUCTOR: Creates our deck object with 52 cards (Constructors should have capital!)
      - INPUT: None
      - PROCCESS: Assigns the input values to the suit and face instance variables
      - OUTPUT: Deck object with array size 52 filled with card objects
   */

   public Deck()
   {
      //Our default deck will be 52 cards so set the array to that
      
      deck = new Card[52];
      
      //call our helper method to fill our array for us
      //give it the default value of 1 since this is our default 1 single deck constructor
      fillDeckArray(1);

   }// end default deck constructor
   
   
     /* 
      - CONSTRUCTOR: Creates our deck object with 52 * n cards
      - INPUT: integer number of decks desired
      - PROCCESS: Fills the deck array with cards and assigns it as instance data to the object
      - OUTPUT: Deck object with an array of length 52 * n, each index filled with a card object
   */
   public Deck(int numberOfDecks)
   {
      this.deck = new Card[52 * numberOfDecks];
      
      fillDeckArray(numberOfDecks);
      
   }// end parameter'd deck constructor
   
   
   /* 
      - HELPER/MUTATOR METHOD: Populates the deck array in a Deck constructor
      - INPUT: integer number of decks
      - PROCCESS: Fills the deck array with cards and assigns it as instance data to the object
      - OUTPUT: Deck object with an array of length 52 * n, each index filled with a card object
   */
   
   //As i was coding i realized my code for populting the array was repetitive so im making a seperate helper method for it
   //we need this helper method to work for both constructors so it will take num of decks input but the default constructor will automatically pass 1
  
  private void fillDeckArray(int numOfDecks)
  {  
      //create a variable to keep track of the posistion in the arrays index during the loop that we can increment
      int cardIndex =0;
      
      
      //creating a loop to make sure we make N number of decks using our parameter not just 1 deck
      for (int n=0; n<numOfDecks; n++)
      {
         //suit loop, there is 4 suits in cards and we need to have all 4 suits PER deck
         for (int i = 0; i<4; i++) 
         {
            //cards value/face loop, there is 13 values in cards so we need to get all 13 values PER suit
            for (int j=0; j<13; j++) 
            {
               deck[cardIndex++] = new Card(i,j);
            }
         }
      }
   }//end helper method        
   
   
   /* 
      - MUTATOR METHOD: Performs the Fisher-Yates shuffle on the deck array with our deck objects
      - INPUT: integer number of decks
      - PROCCESS: Fills the deck array with cards and assigns it as instance data to the object
      - OUTPUT: Deck object with an array of length 52 * n, each index filled with a card object
   */
   public void shuffle()
   {
      //declare all variables, we will need to use random class, variable of Card type for temp place holder and a int for a random index
      
      Random randNum = new Random();
      int randomIndex;
      Card placeHolder;
      
      //we need to loop through every index in the deck array
      //generate a random value within the decks limit
      //so we don't lose the card at deck[i] we set the place holder equal to its value
      //set deck[i] equal to deck of random index, then set deck of random index = to our placeholder variable succesfully swapping the cards
      
      for (int i = 0; i < deck.length; i++) 
      {
         randomIndex = randNum.nextInt(deck.length);
         
         placeHolder = deck[i];
         deck[i] = deck[randomIndex];
         deck[randomIndex] = placeHolder;
      }
   
   } //end class
}