import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String text = read.readLine().toLowerCase();
		String word = read.readLine().toLowerCase();
		
		int count = 0;
		int index = text.indexOf(word);
		
		while (index != -1) {
			count++;
			index = text.indexOf(word, index + 1);
		}
		System.out.println(count);
	}
}
