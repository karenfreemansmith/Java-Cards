import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImgExample implements ActionListener {
  JFrame frame;
  JButton button;
  MyDrawPanel pic;

  public static void main (String[] args) {
    ImgExample i = new ImgExample();
    i.displayScreen();
  }


  public void displayScreen() {
    frame = new JFrame();
    button = new JButton("Change Color");
    button.addActionListener(this);
    pic = new MyDrawPanel();
    frame.getContentPane().add(BorderLayout.SOUTH,button);
    frame.getContentPane().add(BorderLayout.CENTER,pic);
    frame.setSize(300,300);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    this.frame.repaint();
  }

  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      int red = (int) (Math.random() *256);
      int green = (int) (Math.random() * 256);
      int blue = (int) (Math.random() * 256);

      Color randomColor = new Color(red, green, blue);
      g.setColor(randomColor);
      g.fillRect(0,0,this.getWidth(),this.getHeight());

      Image image = new ImageIcon("./../../../../assets/x3.jpg").getImage();
      g.drawImage(image,(this.getWidth()-123)/2,(this.getHeight()-174)/2,this);

    }
  }

}
