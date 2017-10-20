import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\W+");
		Set<String> palindromes = new TreeSet<>();
		
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
