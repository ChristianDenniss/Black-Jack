/****************************************************************
* Black Jack Hand Class
*
* Christian Dennis
* 11/28/2024
* 0.0.1
******************************************************************/

public class Hand
{	
	//create the instance data each one of our Hand objects will possess
	//we will need an array of type Card object, size 12 (we get 12 from the question)
	//also need a variable to track the number of cards in a deck
	private Card[] cardsInHand;	
	private int numOfCards;
	
	/* 
      - CONSTRUCTOR: Creates our Hand object
      - INPUT: None
      - PROCCESS: Assigns instance data and creates Hand object
      - OUTPUT: Hand object with empty array size/length 12 
   */		
	public Hand()
   {	
		numOfCards = 0;
		cardsInHand = new Card[12];
         
   }//end dealer hand constructor
	
	/* 
     - MUTATOR: Add a value to the card array in the Hand object
     - INPUT: The card we are adding
     - PROCCESS: place a card object in the array at index numberOfCards, then increment numberOfCards variable
     - OUTPUT: Array with card placed at num of cards
   */
	public void addCard(Card drawnCard)
	{
		cardsInHand[numOfCards] = drawnCard;
		numOfCards++;
	}
	
	/* 
     - ACCESSOR: Looking at each value in our hand array and concating it to a string
     - INPUT: Boolean to check if the hand is of the dealer or player
     - PROCCESS: iterate thru the array while i less than hands numberOfCards instance data, concat each value at index i to string hand
     - OUTPUT: String with every card in the players hand
   */
	public String printHand(boolean isDealer)
	{
		//create a hand string where we will append each card's toString value
		//if else structure to check if dealer boolean is true or false
		//if true
			//concat "mystery" to the hand string
			//make a loop skipping index 1, to go thru each part of the array while i < num of cards instance data
				//within the loop cardsInMyHand[i].toString to hand
		//else; false
			//make a loop to go thru each part of the array while i < num of cards instance data
				//within the loop cardsInMyHand[i].toString to hand
		//return hand
		
		String hand ="";
		if (isDealer == true)
		{
			for (int i=0; i< numOfCards; i++)
			{	
				hand += cardsInHand[i].toString();
			}
		}
		else
		{
			hand += "Mystery\n";
			for (int i=1; i< numOfCards; i++)
			{	
				hand += cardsInHand[i].toString();
			}
		}
		return hand; 
	}
		
	/* 
     - ACCESSOR: 
     - INPUT: None
     - PROCCESS: Add all the face values of each card to a sum integer
     - OUTPUT: Sum Integer that is the total value of the cards in our hand
   */
	public int sumHand()
	{	
		//create 2 int variables one to total the sum of the hand, 1 to check if the face of the card is a 1, initialize them both to 0
		//iterate thru each index in the array less than numOfCards instance data
			//add the face value of the card at index i to sum
			//check IF the value of face was 1 and it's the first 1 / ace using firstAce == 0
				//if this is true add 10 to our sum integer, this will simulate adding 11 because we've already added it as 1
				
		int sum = 0;
		int firstAce =0;
		for (int i=0; i<numOfCards; i++)
		{
			sum += (cardsInHand[i].getFace());
			
			if (cardsInHand[i].getFace() == 1 && firstAce == 0)
			{
				sum = sum +10;
				firstAce =1;
			}
			
		}
				
		return sum;
	}
	
    
} // end hand class
