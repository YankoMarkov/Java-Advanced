import java.io.*;

public class CountCharacterTypes {

    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new FileReader("resources/words"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("resources/count-chars"))) {
            String vowelsSymbols = "aeiou";
            String punctuationSymbols = "!.,?";
            int vowels = 0;
            int punctuation = 0;
            int consonant = 0;
            int symbols;
            while ((symbols = bfr.read()) != -1) {
                char ch = (char)symbols;
                if (vowelsSymbols.contains(ch + "")) {
                    vowels++;
                } else if (punctuationSymbols.contains(ch + "")) {
                    punctuation++;
                } else if (Character.isLetter(ch)) {
                    consonant++;
                }
            }
            bfw.write(String.format("Vowels: %d%n", vowels));
            bfw.write(String.format("Consonant: %d%n", consonant));
            bfw.write(String.format("Punctuation: %d%n", punctuation));

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
