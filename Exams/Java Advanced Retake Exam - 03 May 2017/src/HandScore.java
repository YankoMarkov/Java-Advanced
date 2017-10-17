import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandScore {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = Arrays.asList(read.readLine().split("\\s+"));
		
		List<Character> cards2to10 = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1');
		List<Character> cardsJtoA = Arrays.asList('J', 'Q', 'K', 'A');
		List<Integer> temp = new ArrayList<>();
		
		int sum = 0;
		for (int i = 0; i <= input.size() - 1; i++) {
			char power = input.get(i).charAt(0);
			char type1 = input.get(i).charAt(input.get(i).length() - 1);
			if (i == input.size() - 1) {
				temp.add(addSum(cards2to10, cardsJtoA, power));
				sum += temp.stream().mapToInt(Integer::valueOf).sum() * temp.size();
				temp.clear();
				break;
			}
			char type2 = input.get(i + 1).charAt(input.get(i + 1).length() - 1);
			if (type1 == type2) {
				temp.add(addSum(cards2to10, cardsJtoA, power));
			} else {
				temp.add(addSum(cards2to10, cardsJtoA, power));
				sum += temp.stream().mapToInt(Integer::valueOf).sum() * temp.size();
				temp.clear();
			}
		}
		System.out.println(sum);
	}
	
	private static int addSum(List<Character> cards2to10, List<Character> cardsJtoA, char ch) {
		int sum = 0;
		if (cards2to10.contains(ch)) {
			sum = cards2to10.indexOf(ch) + 2;
		}
		if (cardsJtoA.contains(ch)) {
			sum = cardsJtoA.indexOf(ch) + 12;
		}
		return sum;
	}
}
