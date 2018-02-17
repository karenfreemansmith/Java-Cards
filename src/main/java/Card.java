public class Card {
  private String suit;
  private String faceValue;
  private String imageURI;
  private boolean faceUp;
  private boolean inDeck;

  public Card(String fv, String s) {
    this.suit = s;
    this.faceValue = fv;
    this.imageURI = fv;
    if(s.equals("♣️")) {
      this.imageURI += "c.jpg";
    }
    if(s.equals("♦️")) {
      this.imageURI += "d.jpg";
    }
    if(s.equals("♥️")) {
      this.imageURI += "h.jpg";
    }
    if(s.equals("♠️")) {
      this.imageURI += "s.jpg";
    }
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

  public String getImageURI() {
    if(this.faceUp) {
      return this.imageURI;
    } else {
      return "x3.jpg";
    }
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
