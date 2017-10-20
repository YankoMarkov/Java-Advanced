import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Character> powers = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
		List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');
		Map<String, Set<String>> result = new LinkedHashMap<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("JOKER")) {
			String[] input = inputs.split(":\\s+");
			String inputName = input[0];
			String[] inputCards = input[1].split(", ");
			Set<String> cards = new HashSet<>();
			
			if (!result.containsKey(inputName)) {
				cards.addAll(Arrays.asList(inputCards));
				result.put(inputName, cards);
			} else {
				cards = result.get(inputName);
				cards.addAll(Arrays.asList(inputCards));
				result.put(inputName, cards);
			}
		}
		for (String name : result.keySet()) {
			System.out.printf("%s: ", name);
			int value = 0;
			for (String card : result.get(name)) {
				int power = powers.indexOf(card.charAt(0)) + 2;
				int suit = suits.indexOf(card.charAt(card.length() - 1)) + 1;
				value += power * suit;
			}
			System.out.println(value);
		}
	}
}
