import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  private int heroX;
  private int heroY;

  Direction direction;

  public Board() {
    heroX = 0;
    heroY = 0;
    direction = Direction.DOWN;


    // set the size of your draw board
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    // graphics.fillRect(testBoxX, testBoxY, 100, 100);
    // here you have a 720x720 canvas
    // you can create and draw an image using the class below e.g.
    String heroImage = "";
    if (direction == Direction.UP){
      heroImage = "hero-up";
    } else if (direction == Direction.DOWN) {
      heroImage = "hero-down";
    } else if (direction == Direction.RIGHT) {
      heroImage = "hero-right";
    } else if (direction == Direction.LEFT) {
      heroImage = "hero-left";
    }

    PositionedImage hero = new PositionedImage("img/" + heroImage + ".png", heroX, heroY);
    PositionedImage floor = new PositionedImage("img/floor.png", 0, 0);
    PositionedImage floor2 = new PositionedImage("img/floor.png", 72, 0);

    floor.draw(graphics);
    floor2.draw(graphics);
    hero.draw(graphics);
  }

  public static void main(String[] args) {
    // Here is how you set up a new window and adding our board to it
    JFrame frame = new JFrame("Wanderer");
    Board board = new Board();
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    // Here is how you can add a key event listener
    // The board object will be notified when hitting any key
    // with the system calling one of the below 3 methods
    frame.addKeyListener(board);
    // Notice (at the top) that we can only do this
    // because this Board class (the type of the board object) is also a KeyListener
  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      heroY -= 72;
      direction = Direction.UP;
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      heroY += 72;
      direction = Direction.DOWN;
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      heroX += 72;
      direction = Direction.RIGHT;
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      heroX -= 72;
      direction = Direction.LEFT;
    }
    // and redraw to have a new picture with the new coordinates
    repaint();
  }
}
