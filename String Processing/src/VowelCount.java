import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class VowelCount {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		
		List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y');
		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (vowels.contains(input.charAt(i))) {
				count++;
			}
		}
		System.out.printf("Vowels: %d", count);
	}
}
