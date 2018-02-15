import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
  public static void main(String[] args) {
    Deck mycards = new Deck();
    String menu = "Welcome to Play Cards!\n";
    menu += "Enter 1 to view new deck\n";
    menu += "Enter 2 to view shuffled deck\n";
    menu += "Enter 3 to draw 5 cards from shuffled deck\n";
    menu += "Enter 9 to quit\n";
    int activity = Integer.parseInt(prompt(menu));
    while(activity <= 3) {
      switch (activity) {
        case 1:
          showNewCards(mycards);
          break;
        case 2:
          showShuffledCards(mycards);
          break;
        case 3:
          showFiveCards(mycards);
          break;
        default:

          break;
      }
      activity = Integer.parseInt(prompt(menu));
    }
  }

  private static void showNewCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    for(int i=0; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
  }
  private static void showShuffledCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    mycards.shuffle();
    for(int i=0; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
  }
  private static void showFiveCards(Deck mycards) {
    mycards = new Deck();
    mycards.shuffle();
    Card mycard1 = mycards.draw();
    mycard1.showCard();
    Card mycard2 = mycards.draw();
    mycard2.showCard();
    Card mycard3 = mycards.draw();
    mycard3.showCard();
    Card mycard4 = mycards.draw();
    mycard4.showCard();
    Card mycard5 = mycards.draw();
    mycard5.showCard();
    System.out.println(" _____   _____   _____   _____   _____ ");
    System.out.println("|     | |     | |     | |     | |     |");
    System.out.println("|     | |     | |     | |     | |     |");
    System.out.println("| " + mycard1.toString() + " | | " + mycard2.toString() + " | | " + mycard3.toString() + " | | " + mycard4.toString() + " | | " + mycard5.toString() + " |");
    System.out.println("|     | |     | |     | |     | |     |");
    System.out.println("|     | |     | |     | |     | |     |");
    System.out.println(" _____   _____   _____   _____   _____ ");
  }
  private static void printCard(Card c) {
    System.out.println(" _____");
    System.out.println("|     |");
    System.out.println("|     |");
    System.out.println("| " + c.toString() + " |");
    System.out.println("|     |");
    System.out.println("|_____|\n");
  }
  private static String prompt(String s) {
    String response="";
    System.out.println(s);
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      response = bufferedReader.readLine();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return response;
  }
}
