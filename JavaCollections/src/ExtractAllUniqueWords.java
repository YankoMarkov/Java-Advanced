
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ExtractAllUniqueWords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = input.nextLine().toLowerCase();
        String[] words = text.split("\\W+");
        Set<String> uniqueWords = new TreeSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        for (String uniqueWord : uniqueWords) {
            System.out.print(uniqueWord + " ");
        }
    }
}
