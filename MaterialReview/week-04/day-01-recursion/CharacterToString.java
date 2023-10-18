import java.util.ArrayList;
import java.util.List;

public class CharacterToString {
    public static void main(String[] args) {
        String word = "Hello World";
        List<String> selectedChars = new ArrayList<>();

        for (int i = 0; i < word.length(); i += 2) {
            selectedChars.add(String.valueOf(word.charAt(i)));
        }

        String newWord = String.join("", selectedChars);
        System.out.println(newWord);
    }
}
