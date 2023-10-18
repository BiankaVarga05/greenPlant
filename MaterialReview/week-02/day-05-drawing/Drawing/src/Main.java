//region rendering
// immediate mode: Client calls --> re-render all
// retained mode: Client calls --> update the internal model --> optimize logic --> render what needs to be rendered (what changed)
//endregion


// https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html


// create an 800 * 800 canvas
// 1. Draw an equilateral triangle to the bottom of the screen
//   It shall be in the center and the size of its edges must be 100
//   Tip: You can get the height of the triangle from the size like this:
//   https://socratic.org/questions/what-is-the-height-and-area-of-an-equilateral-triangle-with-a-base-of-10-meters

// 2. Make it random colored
// 3. Create 5 multiple random colored triangles

//region extra
// 4. Place the drawing logic into a function that receives a character and a number as parameters
//   This function draws only the shades of that color that is given as parameter
//   (r = red, g = green, b = blue)
//   if none of these are given, randomize all color components
//   draw as many triangles as given by the number parameter
//endregion

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
  public static void drawImage(Graphics graphics){
    int triangles = 100;
    int size = 600;
    for (int i = 0; i < triangles; i++) {
      drawSingleTriangle(graphics, size - i * size  / triangles);
    }
  }

  public static void drawSingleTriangle(Graphics graphics, int size){
    Random random = new Random();
    int red = random.nextInt(256);
    int green = random.nextInt(256);
    int blue = random.nextInt(256);
    Color color = new Color(red, green, blue);
    graphics.setColor(color);
    int triangleHeight = (int)((Math.sqrt(3)/2) * size);
    int[] xCoordinates = {WIDTH/2,(WIDTH/2)+(size/2), (WIDTH/2)-(size/2) };
    int[] yCoordinates =  {HEIGHT-triangleHeight, HEIGHT, HEIGHT};
    graphics.fillPolygon(xCoordinates, yCoordinates, 3);
  }

  //region Don't touch the code below
  static int WIDTH = 600;
  static int HEIGHT = 600;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("DrawingDemo");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      drawImage(graphics);
    }
  }
  //endregion
}
