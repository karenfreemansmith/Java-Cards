import org.junit.*;
import static org.junit.Assert.*;

public class DeckTest {
  private Deck mDeck;

  @Test
  public void newDeckHas52Cards() {
    mDeck = new Deck();
    assertEquals(52, mDeck.cardsRemaining());
  }

  @Test
  public void drawCardReducesCardsRemaining() {
    mDeck = new Deck();
    Card testCard = mDeck.draw();
    assertEquals(51, mDeck.cardsRemaining());
  }

  @Test
  public void deckIsEmpty() throws Exception {
    mDeck = new Deck();
    Card testCard;
    for(int i=0; i<53; i++) {
      testCard = mDeck.draw();
    }
    assertEquals(0, mDeck.cardsRemaining());
  }

  @Test
  public void newDeckIsOrdered() {
    mDeck = new Deck();
    Card testCard = mDeck.draw();
    testCard.showCard();
    assertEquals("A♣️", testCard.toString());
  }

  @Test
  public void shuffledDeckIsNotOrdered() {
    //this test could be better, there is a chance the first card will be the same after shuffling.
    mDeck = new Deck();
    mDeck.shuffle();
    Card testCard = mDeck.draw();
    testCard.showCard();
    assertNotEquals("A♣️", testCard.toString());
  }
}
