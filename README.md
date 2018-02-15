# Java Card Deck
Version 0.0.0: February 15, 2018 by [Karen Freeman-Smith](https://github.com/karenfreemansmith)

## Description
a set of classes that represent a deck of cards

## Specifications
You should be able to “shuffle” the deck.  You should also be able to draw cards from the deck one at a time until the deck is empty.  Include tests.

* Card class:
  properties
  - suit ( ♣️ ♦️ ♥️ ♠️ )
  - faceValue ( A 1 2 3 4 5 6 7 8 9 10 J Q K )
  - faceUp (boolean)
  - inDeck (boolean)
  methods
  - flip (toggles faceup)
  - toString
    - returns faceValue & suit if faceUp
    - returns XXX if not faceUp

* Deck class:
  properties
  - collection of cards
    - has 52 cards total
    - has 13 faceValues in each of 4 suits
    - 4 suits in each of 13 faceValues
  methods
  - reset
    - deck is ordered
  - shuffle
    - deck not in original order
  - draw
    - countRemaining is -1 from before draw
    - not available if countRemaining is 0
  - countRemaining
    - number of cards left in deck

## Setup/Installation
* Clone directory
* Run gradle compileJava
* navigate to build/classes/main
* run program by typing "java App"

## Support & Contact
For questions, concerns, or suggestions please email karenfreemansmith@gmail.com

## Technologies Used
Java, Gradle, junit

## Legal
Copyright (c) 2018 Copyright _Karen Freeman-Smith_ All Rights Reserved.
