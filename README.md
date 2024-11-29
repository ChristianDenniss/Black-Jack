# Black-Jack
Making a simple Black Jack game for a Java Assignment

ASSIGNMENT:

Fall 2024 CS 1073 Assignment #6 & Lab # 10
Due Date: Friday Wednesday December 4
th, 2024 by 11:59pm
Instructions: Recall assignment submissions have changed.
 Type your algorithm/design as your code comments (or 0assigned)
 Methods need headers - describe the purpose and black box idea
 Your code goes into your algorithm
 Collect and print exactly 3 random test cases (can edit them to one page)
1. BlackJack:
 (LAB) Write a class to represent a Card defined as follows: A card contains 2
components: face (an integer from 1 to 13 where 1 represents an Ace, 2 a Two,
.... 10 a Ten, 11 a Jack, 12 a Queen and 13 a King) and suit (where 1 represents
Hearts, 2 represents Clubs, 3 represents Spades and 4 represents Diamonds). Have
the constructor be parameter-ed to accept - in order integers representing face and
suit. Your class should contain accessor methods for each instance variable as both
String and as an int (no mutators), and an appropriate toString which will represent
the card as a string (such as Ace of Hearts). You may add any other components
you feel are necessary.
 (LAB) Write a class to represent a Deck of cards. Have your default constructor
instantiate a deck of cards containing all 52 cards in an array. Include a parameterized constructor which accepts an integer N and constructs a Deck which contains
the cards to represent N standard decks of cards (for example N = 2 would be 104
cards - two standard decks). Your deck should contain the following methods
(a) shuffle - write a method to randomize the order of the deck of cards using the
Fisher–Yates shuffle.
(b) deal - write a method which “REMOVES” the first card from the deck returning it as the return. Pretend to remove it by simulating that that part of the
array is no longer available using a partially filled array concept. You might
find it easier to deal from the “bottom” of the deck. You can assume your
deck never runs out and we will look at this assumption later in the course
again.
You may add any other components you feel are necessary.
 (LAB) Write a class to represent a Hand of cards which starts as an empty array.
You can assume a hand of cards will never hold more than 12 cards. Include a
method to add a card to the hand. Another method should print out the hand
based on a boolean variable is Dealer. If its true, only print the fisrt card as the
word “mystery”.
Add a method compute which computes the blackjack value of a hand. Assume
the first Ace is worth 11 and all other Aces are worth 1 unless the hand total goes
over 21 - in which case the first Ace card changes value to 1. Mulitple booleans will
help control this (hasAceAs11 and hasAce). Each other card is worth its face value
(a 2 is 2, a 3 is 3 with 10, 11, 12, and 13 all being worth 10 points only). Add a
toString method to print out a hand of cards with each card on a separate line as
well as a blank line after the hand. You may add any other components you feel
are necessary.
 (GAME) Write a client file to play a game of Blackjack as follows:
(a) Create a shuffled deck of cards consisting of 6 standard decks
(b) Deal a card the players hand, a card to the dealers hand, a second card to the
players hand and a second card to the dealers hand
(c) Reveal to the players their cards and the hand score so far
(d) Reveal to the player only the first card of the dealers hand (do not reveal the
score)
(e) If the players score is 21 and the dealer also has 21 inform them they tied (no
winner, no loser). Reveal the dealers hand and its score. Otherwise continue
(f) If the players score is 21 and the dealer has less than 21 inform the player that
they won. Reveal the dealers hand and its score. Otherwise continue
(g) If the dealers score is 21 inform the player that they lost. Reveal the dealers
hand and its score. Otherwise continue
(h) While the players hand is less than 21 ask the player if they wish to hit (add
another card to their hand) or stay (stop adding new cards to their hand).
(i) If the players hand goes over 21 inform the player immediately that they lost
and reveal the dealers hand and its score. Otherwise continue
(j) If the players hand is 21 or less show them the dealers hand and its score and
then play the dealers hand according to the following rules:
– While the dealers hand is under 17 they must take another card (show the
dealers new card and the new dealer hand score)
– If the dealers hand is 17 or higher the dealer must stop
(k) If the dealers score is over 21 inform the player they have won
(l) If the players score is more than the dealer hand, they win.
(m) If the players score is the same than the dealer hand, they tie (called a push)
(n) If the players score is less than the dealer hand, they lose.
(o) Ask if the players wishes to play again. If yes clear the player and dealer hands
but keep playing from the same deck of cards.
 Finally add in a money factor where the player starts with $1000.00 and each hand
costs $200.00 to play. Losing means you lose your bet, a push means you keep your
bet and a win ,means you keep and win your bet. If you win with 21 in two cards,
you win 1.5 times your bet (plus keep your bet). Do not let them play if unable to
pay the necessary $200.00.
Hand in your final compete version of this game according to the style guide. Print
output from running your program where you played exactly 3 times. Include a strong
test case in this playing of the game.
