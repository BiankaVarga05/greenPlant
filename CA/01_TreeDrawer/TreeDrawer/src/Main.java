public class Main {
  public static void main(String[] args) {
    int linesPerSection = 5;
    int topIncrement = 1;
    int bottomIncrement = 2;
    int sectionIncrement = 2;
    int trunkHeight = 2;
    String leafSing = "*";
    String airSign = " ";
    String trunkSign = "|";

    int width = 1 + (2 * sectionIncrement) + ((linesPerSection - 1) * 2 * bottomIncrement);
    int center = (width - 1) / 2;

    for (int sectionCounter = 0; sectionCounter < 2; sectionCounter++) {
      boolean isTop = sectionCounter == 0;
      int actualSideIncrement = isTop ? topIncrement : bottomIncrement;   // ternary operator
      int actualSectionIncrement = isTop ? 0 : sectionIncrement;

      for (int row = 0; row < linesPerSection; row++) {
        for (int column = 0; column < width; column++) {
          if (column == center || (column >= center - (row * actualSideIncrement) - actualSectionIncrement
            && column <= center + (row * actualSideIncrement) + actualSectionIncrement)) {
            System.out.print(leafSing);
          } else {
            System.out.print(airSign);
          }
        }
        System.out.println();
      }
    }

/*
    for (int i = 0; i < linesPerSection; i++) {
      for (int j = 0; j < width; j++) {
        if (j == center || (j >= center - (i * bottomIncrement) - sectionIncrement
          && j <= center + (i * bottomIncrement) + sectionIncrement)){
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
*/
    for (int row = 0; row < trunkHeight; row++) {
      for (int column = 0; column < width; column++) {
        if (column == center - 1 || column == center + 1) {
          System.out.print(trunkSign);
        } else {
          System.out.print(airSign);
        }
      }
      System.out.println();
    }
  }
}
