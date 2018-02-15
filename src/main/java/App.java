public class App {
  public static void main(String[] args) {
    Deck mycards = new Deck();
    Card mycard = mycards.draw();
    mycard.showCard();
    System.out.println("*******\nNew Deck - Unshuffled\n*******");
    printCard(mycard);
    for(int i=1; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
    mycards = new Deck();
    mycards.shuffle();
    System.out.println("*******\nShuffled\n*******");
    for(int i=0; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
  }

  private static void printCard(Card c) {
    System.out.println(" _____");
    System.out.println("|     |");
    System.out.println("|     |");
    System.out.println("| " + c.toString() + " |");
    System.out.println("|     |");
    System.out.println("|_____|\n");
  }
}
