import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App implements ActionListener{
  Deck mycards = new Deck();
  JFrame frame;
  JButton newDeckBtn;
  JButton shuffleBtn;
  JButton draw5Btn;
  CardPanel[] card = new CardPanel[5];

  public static void main(String[] args) {
    App swingApp = new App();
    swingApp.showIt();
  }

  public void showIt() {
    frame = new JFrame();
    JPanel btnPanel = new JPanel();
    newDeckBtn = new JButton("New Deck");
    newDeckBtn.addActionListener(this);
    btnPanel.add(newDeckBtn);
    shuffleBtn = new JButton("Shuffle");
    shuffleBtn.addActionListener(this);
    btnPanel.add(shuffleBtn);
    draw5Btn = new JButton("Draw 5 Cards");
    draw5Btn.addActionListener(this);
    btnPanel.add(draw5Btn);
    frame.getContentPane().add(BorderLayout.NORTH, btnPanel);
    frame.setSize(780,280);

    JPanel handPanel = new JPanel(new GridLayout(1,5,1,1));
    card[0] = new CardPanel();
    card[1] = new CardPanel();
    card[2] = new CardPanel();
    card[3] = new CardPanel();
    card[4] = new CardPanel();
    handPanel.add(card[0]);
    handPanel.add(card[1]);
    handPanel.add(card[2]);
    handPanel.add(card[3]);
    handPanel.add(card[4]);
    frame.getContentPane().add(BorderLayout.CENTER,handPanel);
    frame.setVisible(true);
    frame.repaint();
  }

  class CardPanel extends JPanel {
    private String imgURL="x1.jpg";
    public void paintComponent(Graphics g) {
      // int red = (int) (Math.random() * 66);
      // int green = (int) (Math.random() * 66);
      // int blue = (int) (Math.random() * 66);
      //
      // Color randomColor = new Color(red, green, blue);

      g.setColor(new Color(29, 83, 106));
      g.fillRect(0,0,this.getWidth(),this.getHeight());
      Image img = new ImageIcon("./../../../../assets/" + this.imgURL).getImage();
      g.drawImage(img,(this.getWidth()-123)/2,(this.getHeight()-174)/2,this);
    }
     public void setImgURL(String url) {
       this.imgURL = url;
     }
  }

  public void actionPerformed(ActionEvent event) {
    if(event.getActionCommand().equals("New Deck")) {
      showNewCards(mycards);
    }
    if(event.getActionCommand().equals("Shuffle")) {
      showShuffledCards(mycards);
    }
    if(event.getSource() == draw5Btn) {
      showFiveCards(mycards);
    }
  }

  private void showNewCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    for(int i=0; i<5; i++) {
      mycard = mycards.draw();
      //mycard.showCard();
      displayCard(mycard,i);
    }
  }

  private void showShuffledCards(Deck mycards) {
    Card mycard = mycards.draw();
    mycards = new Deck();
    mycards.shuffle();
    for(int i=0; i<5; i++) {
      mycard = mycards.draw();
      mycard.showCard();
      displayCard(mycard,i);
    }
  }

  private void showFiveCards(Deck mycards) {
    mycards = new Deck();
    mycards.shuffle();
    Card mycard1 = mycards.draw();
    mycard1.showCard();
    card[0].setImgURL(mycard1.getImageURI());
    Card mycard2 = mycards.draw();
    mycard2.showCard();
    card[1].setImgURL(mycard2.getImageURI());
    Card mycard3 = mycards.draw();
    mycard3.showCard();
    card[2].setImgURL(mycard3.getImageURI());
    Card mycard4 = mycards.draw();
    mycard4.showCard();
    card[3].setImgURL(mycard4.getImageURI());
    Card mycard5 = mycards.draw();
    mycard5.showCard();
    card[4].setImgURL(mycard5.getImageURI());
    frame.repaint();
  }

  private void displayCard(Card c, int pos) {
    card[pos].setImgURL(c.getImageURI());
    frame.repaint();
  }

}
