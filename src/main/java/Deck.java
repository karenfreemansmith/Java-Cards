import java.util.Collections;
import java.util.Arrays;

public class Deck {
  private Card[] cards = new Card[52];
  private int nextCard = 0;

  public Deck() {
    this.reset();
  }

  public int cardsRemaining() {
    int count = 0;
    for(Card c: this.cards) {
      if(c.isInDeck()) {
        count++;
      }
    }
    return count;
  }

  public Card draw() {
    try {
      this.cards[nextCard].dealCard();
      nextCard++;
    } catch(NullPointerException e) {
      e.printStackTrace();
    }
    return this.cards[nextCard-1];
  }

  public void shuffle() {
    Collections.shuffle(Arrays.asList(cards));
  }

  private void reset() {
    String[] suits = new String[] { "♣️", "♦️", "♥️", "♠️" };
    String[] faceValues = new String [] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    int index = 0;
    for(String s: suits) {
      for(String fv: faceValues) {
        cards[index] = new Card(fv, s);
        index++;
      }
    }
  }
}
