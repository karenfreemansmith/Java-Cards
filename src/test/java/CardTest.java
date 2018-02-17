import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {
  private Card mCard;

  @Before
  public void initialize() {
    mCard = new Card("A", "♠️");
  }

  @Test
  public void cardToStringReturnsCorrectStringForFaceUp() {
    mCard.showCard();
    assertEquals("A♠️ ", mCard.toString());
  }

  @Test
  public void cardToStringReturnsCorrectStringforNotFaceUp() {
    mCard.hideCard();
    assertEquals("XXX", mCard.toString());
  }

  @Test
  public void cardImageReturnsCorrectStringForFaceUp() {
    mCard.showCard();
    assertEquals("As.jpg", mCard.getImageURI());
  }

  @Test
  public void cardImageReturnsCorrectStringforNotFaceUp() {
    mCard.hideCard();
    assertEquals("x3.jpg", mCard.getImageURI());
  }

  @Test
  public void dealtCardNotInDeck() {
    mCard.dealCard();
    assertEquals(false, mCard.isInDeck());
  }

  @Test
  public void returnedCardInDeck() {
    mCard.returnCard();
    assertEquals(true, mCard.isInDeck());
  }
}
