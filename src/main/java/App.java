import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App implements ActionListener{
  Deck mycards = new Deck();
  JButton newDeckBtn;
  JButton shuffleBtn;
  JButton draw5Btn;

  public static void main(String[] args) {
    App swingApp = new App();
    swingApp.showIt();
  }

  public void showIt() {
    JFrame frame = new JFrame();
    newDeckBtn = new JButton("New Deck");
    newDeckBtn.addActionListener(this);
    frame.getContentPane().add(newDeckBtn);
    shuffleBtn = new JButton("Shuffle");
    shuffleBtn.addActionListener(this);
    frame.getContentPane().add(shuffleBtn);
    draw5Btn = new JButton("Draw 5 Cards");
    draw5Btn.addActionListener(this);
    frame.getContentPane().add(draw5Btn);
    frame.setSize(500,150);
    FlowLayout flo = new FlowLayout();
    frame.setLayout(flo);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    if(event.getActionCommand().equals("New Deck")) {
      showNewCards(mycards);
    }
    if(event.getActionCommand().equals("Shuffle")) {
      showShuffledCards(mycards);
    }
    if(event.getActionCommand().equals("Draw 5 Cards")) {
      showFiveCards(mycards);
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

}
