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
  JTextArea cardDisplay;

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
    frame.setSize(640,480);
    cardDisplay = new JTextArea("",20,50);
    cardDisplay.setFont(new Font("Courier New", Font.PLAIN, 16));
    cardDisplay.setLineWrap(true);
    cardDisplay.setWrapStyleWord(true);
    JScrollPane scroll = new JScrollPane(cardDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    frame.getContentPane().add(scroll);
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

  private void showNewCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    for(int i=0; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
  }
  private void showShuffledCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    mycards.shuffle();
    for(int i=0; i<52; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      printCard(mycard);
    }
  }
  private void showFiveCards(Deck mycards) {
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
    String pCard = "";
    pCard += " _____\t _____\t _____\t _____\t _____\n";
    pCard += "|     |\t|     |\t|     |\t|     |\t|     |\n";
    pCard += "|     |\t|     |\t|     |\t|     |\t|     |\n";
    pCard += "| " + mycard1.toString() + "|\t| " + mycard2.toString() + "|\t| " + mycard3.toString() + "|\t| " + mycard4.toString() + "|\t| " + mycard5.toString() + "|\n";
    pCard += "|     |\t|     |\t|     |\t|     |\t|     |\n";
    pCard += "|_____|\t|_____|\t|_____|\t|_____|\t|_____|\n\n";
    cardDisplay.append(pCard);
  }
  private void printCard(Card c) {
    String pCard = "";
    pCard += " _____\n";
    pCard += "|     |\n";
    pCard += "|     |\n";
    pCard += "| " + c.toString() + "|\n";
    pCard += "|     |\n";
    pCard += "|_____|\n\n";
    cardDisplay.append(pCard);
  }

}
