import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncryptSortAndPrintArray {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Integer> result = new ArrayList<>();
		List<String> vowels = Arrays.asList("A", "a", "E", "e", "I", "i", "O", "o", "U", "u");
		
		for (int i = 0; i < num; i++) {
			String input = read.readLine();
			int total = 0;
			for (int j = 0; j < input.length(); j++) {
				String letter = Character.toString(input.charAt(j));
				if (vowels.contains(letter)) {
					total += input.charAt(j) * input.length();
				} else {
					total += input.charAt(j) / input.length();
				}
			}
			result.add(total);
		}
		Collections.sort(result);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
}
