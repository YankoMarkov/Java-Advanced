import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MagicExchangeableWords {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		
		System.out.println(magicExchangeableWords(input[0], input[1]));
	}
	
	private static boolean magicExchangeableWords(String shortest, String longest) {
		Map<Character, Character> chatMap = new HashMap<>();
		String small;
		String big;
		
		if (shortest.length() <= longest.length()) {
			big = longest;
			small = shortest;
		} else {
			big = shortest;
			small = longest;
		}
		for (int i = 0; i < small.length(); i++) {
			if (!chatMap.containsKey(big.charAt(i))) {
				chatMap.put(big.charAt(i), small.charAt(i));
			}
			if (chatMap.get(big.charAt(i)) != small.charAt(i)) {
				return false;
			}
		}
		for (int i = small.length(); i < big.length(); i++) {
			if (!chatMap.containsKey(big.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
