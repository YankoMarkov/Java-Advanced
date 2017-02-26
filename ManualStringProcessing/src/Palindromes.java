
import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\W+");
        Collator collator = Collator.getInstance(Locale.US);
        Set<String> palindromes = new TreeSet<>(collator);

        for (String word : input) {
            boolean isPalindrome = checkForPalindromes(word);
            if (isPalindrome) {
                palindromes.add(word);
            }
        }
        System.out.println(palindromes);
    }

    private static boolean checkForPalindromes(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
