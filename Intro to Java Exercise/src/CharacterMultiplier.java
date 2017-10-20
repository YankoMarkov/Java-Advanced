import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		String first = input[0];
		String second = input[1];
		String small = "";
		String large = "";
		
		if (first.length() <= second.length()) {
			small = first;
			large = second;
		} else {
			small = second;
			large = first;
		}
		
		int index = 0;
		int sum = 0;
		for (int i = 0; i < small.length(); i++) {
			char a = small.charAt(i);
			char b = large.charAt(i);
			sum += a * b;
			index ++;
		}
		
		if (index < large.length()) {
			for (int i = index; i < large.length(); i++) {
				char c = large.charAt(i);
				sum += c;
			}
		}
		System.out.println(sum);
	}
}
