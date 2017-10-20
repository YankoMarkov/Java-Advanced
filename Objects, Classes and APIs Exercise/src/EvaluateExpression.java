import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class EvaluateExpression {
	
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
		while (digits.size() >= 1) {
			String token = digits.pop();
			try {
				double a = Double.parseDouble(token);
				operators.push(token);
			} catch (Exception e) {
				String operand1 = operators.pop();
				String operand2 = operators.pop();
				String result = doMath(token, operand1, operand2);
				operators.push(result);
			}
		}
		System.out.printf("%.2f", Double.parseDouble(operators.peek()));
	}
	
	private static String doMath(String token, String operand1, String operand2) {
		if (token.equals("*")) {
			return Double.toString(Double.parseDouble(operand1) * Double.parseDouble(operand2));
		} else if (token.equals("/")) {
			return Double.toString(Math.max(Double.parseDouble(operand2), Double.parseDouble(operand2)) /
					Math.min(Double.parseDouble(operand1), Double.parseDouble(operand2)));
		} else if (token.equals("+")) {
			return Double.toString(Double.parseDouble(operand1) + Double.parseDouble(operand2));
		} else {
			return Double.toString((Double.parseDouble(operand2) - Double.parseDouble(operand1)));
		}
	}
}
