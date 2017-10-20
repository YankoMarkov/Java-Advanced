import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			result = result.append(String.format("\\u00%x", (int) input.charAt(i)));
		}
		System.out.println(result);
	}
}
