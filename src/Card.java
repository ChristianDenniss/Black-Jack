/****************************************************************
* Black Jack Card Class
*
* Christian Dennis
* 11/28/2024
* 0.0.1
******************************************************************/

//prompt; write a class that will createa card object with accessors
//make the Card class and within it create instance data int face and int suit for our method to use

public class Card
{
   private int face;
   private int suit;
   
   /* 
      - CONSTRUCTOR: Creates our card object (Constructors should have capital!)
      - INPUT: The two integer instance variables from the Card class suit and face (in that order)
      - PROCCESS: Assigns the input values to the suit and face instance variables
      - OUTPUT: Card object with two initialized variables for its suit and face
   */
   public Card(int suit, int face)
   {
      this.face = face;
      this.suit = suit;
   }
   
    /* 
      - ACCESSOR: Acesses and returns the face instance data
      - INPUT: None
      - PROCCESS: Returns the value stored in the face instance variable
      - OUTPUT: The face value of the card   
   */
   public int getFace() {
      return face;
   }

    /* 
      - ACCESSOR: Acesses and returns the suit instance data
      - INPUT: None
      - PROCCESS: Returns the value stored in the suit instance variable
      - OUTPUT: The suit value of the card   
    */
   public int getSuit() {
      return suit;
   }
	
	public String toString() 
	{
      String cardR = "";
      String suitR = "";
      
      if (suit == 0)
      { 
         suitR = "Hearts";
      }
      else if (suit == 1)
      { 
         suitR = "Spades";
      }
      else if (suit == 2)
      { 
         suitR = "Clubs";
      }
      else if (suit == 3)
      { 
         suitR = "Diamonds";
      }
      else 
      {
         suitR = "Unrecognized Value";
      }
      
      
      if (face == 1)
      { 
         cardR = "Ace";
      }
      else if (face == 2)
      { 
         cardR = "Two";
      }
      else if (face == 3)
      { 
         cardR = "Three";
      }
      else if (face == 4)
      { 
         cardR = "Four";
      }
      else if (face == 5)
      { 
         cardR = "Five";
      }
      else if (face == 6)
      { 
         cardR = "Six";
      }
      else if (face == 7)
      { 
         cardR = "Seven";
      }
      else if (face == 8)
      { 
         cardR = "Eight";
      }
      else if (face == 9)
      { 
         cardR = "Nine";
      }
      else if (face == 10)
      { 
         cardR = "Ten";
      }
      else if (face == 11)
      { 
         cardR = "Jack";
      }
      else if (face == 12)
      { 
         cardR = "Queen";
      }
      else if (face == 13)
      { 
         cardR = "King";
      }
      else 
      {
         suitR = "Unrecognized Value";
      }

   	return cardR + " of " + suitR + ", "; 
   }
}
