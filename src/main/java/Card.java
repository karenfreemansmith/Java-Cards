public class Card {
  private String suit;
  private String faceValue;
  private boolean faceUp;
  private boolean inDeck;

  public Card(String fv, String s) {
    this.suit = s;
    this.faceValue = fv;
    this.faceUp = false;
    this.inDeck = true;
  }

  public void showCard() {
    this.faceUp = true;
  }

  public void hideCard() {
    this.faceUp = false;
  }

  public void dealCard() {
    this.inDeck = false;
  }

  public void returnCard() {
    this.inDeck = true;
  }

  public boolean isInDeck() {
    return this.inDeck;
  }

  @Override
  public String toString() {
    if(this.faceUp) {
      if(!this.faceValue.equals("10")) {
        this.suit+=" ";
      }
      return this.faceValue + this.suit;
    } else {
      return "XXX";
    }
  }
}
