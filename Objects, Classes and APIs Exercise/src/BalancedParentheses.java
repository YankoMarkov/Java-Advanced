import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		
		Deque<Character> stack = new ArrayDeque<>();
		boolean isBalanced = true;
		
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			if (symbol == '{' || symbol == '(' || symbol == '[') {
				stack.push(symbol);
			} else {
				if (symbol == '}') {
					symbol = '{';
				} else if (symbol == ')') {
					symbol = '(';
				} else {
					symbol = '[';
				}
				if (stack.isEmpty()) {
					isBalanced = false;
					break;
				}
				if (stack.peek() == symbol) {
					stack.pop();
				} else {
					isBalanced = false;
					break;
				}
			}
		}
		if (isBalanced) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
