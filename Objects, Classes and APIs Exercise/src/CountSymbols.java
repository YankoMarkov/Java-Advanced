import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		Map<Character, Integer> result = new TreeMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			char letter = input.charAt(i);
			if (!result.containsKey(letter)) {
				result.put(letter, 1);
			} else {
				result.put(letter, result.get(letter) + 1);
			}
		}
		for (Map.Entry<Character, Integer> res : result.entrySet()) {
			System.out.printf("%s: %d time/s%n", res.getKey(), res.getValue());
		}
	}
}
