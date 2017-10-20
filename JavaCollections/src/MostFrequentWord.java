import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MostFrequentWord {

    private static Map<String, Integer> countWords(String[] text, Map<String, Integer> words) {
        for (String word : text) {
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, count + 1);
        }
        return words;
    }

    private static void printMaxCountWords(Map<String, Integer> words, int count) {
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() == count) {
                System.out.println(word.getKey() + " -> " + word.getValue() + " times.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String[] text = input.nextLine().toLowerCase().split("\\W+");
        Map<String, Integer> wordsCount = new TreeMap<>();
        wordsCount = countWords(text, wordsCount);
        int maxCount = Collections.max(wordsCount.values());
        printMaxCountWords(wordsCount, maxCount);
    }
}
