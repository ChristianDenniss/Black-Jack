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
   	return face + " of " + suit + "\n"; 
   }
}
