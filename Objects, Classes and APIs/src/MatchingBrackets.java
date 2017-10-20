import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		
		Deque<Integer> result = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			if (symbol == '(') {
				result.push(i);
			} else if (symbol == ')') {
				String res = input.substring(result.pop(), i + 1);
				System.out.println(res);
			}
		}
	}
}
