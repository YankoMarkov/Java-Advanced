import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class InfixToPostfix {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split(" ");
		Deque<String> operators = new ArrayDeque<>();
		Deque<String> digits = new ArrayDeque<>();
		Map<String, Integer> priorities = new HashMap<>();
		priorities.put("*", 3);
		priorities.put("/", 3);
		priorities.put("+", 2);
		priorities.put("-", 2);
		priorities.put("(", 1);
		
		for (String str : input) {
			if (str.equals("+") ||
					str.equals("-") ||
					str.equals("*") ||
					str.equals("/") ||
					str.equals("(") ||
					str.equals(")")) {
				switch (str) {
					case "(":
						operators.push(str);
						break;
					case ")":
						while (!operators.peek().equals("(")) {
							digits.add(operators.pop());
						}
						operators.pop();
						break;
					default:
						if (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(str)) {
							digits.add(operators.pop());
						}
						operators.push(str);
						break;
				}
			} else {
				digits.add(str);
			}
		}
		while (!operators.isEmpty()) {
			digits.add(operators.pop());
		}
		for (String digit : digits) {
			System.out.print(digit + " ");
		}
	}
}
