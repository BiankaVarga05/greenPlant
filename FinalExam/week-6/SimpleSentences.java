// https://www.codewars.com/kata/5297bf69649be865e6000922

public class SimpleSentences {
    public static String makeSentence(String[] parts) {
        String sentence = "";

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(".")) {
                continue;
            } else if (parts[i].equals(",") || i == 0) {
                sentence += parts[i];
            } else {
                sentence += " " + parts[i];
            }
        }

        return sentence + ".";
    }

    public static void main(String[] args) {
        System.out.println(makeSentence(new String[]{"hello", ",", "my", "dear", ".", "."}));
    }
}
