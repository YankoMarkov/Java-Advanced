import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		
		Pattern pattern = Pattern.compile("(\\d+)|([^\\d]+)");
		Matcher matcher = pattern.matcher(input);
		List<String> result = new ArrayList<>();
		
		while (matcher.find()) {
			if (matcher.group(1) != null) {
				result.add(matcher.group(1));
			}
			if (matcher.group(2) != null && !result.isEmpty()) {
				if (matcher.group(2).length() % 2 == 0) {
					result.add("+");
				} else {
					result.add("-");
				}
			}
		}
		if (!Character.isDigit(result.get(result.size() - 1).charAt(0))) {
			result.remove(result.size() - 1);
		}
		int sum = 0;
		int num = 0;
		String symbol = "";
		for (int i = 0; i < result.size(); i += 2) {
			num = Integer.valueOf(result.get(i));
			if (i == 0) {
				sum = num;
			} else {
				symbol = result.get(i - 1);
				if (symbol.equals("+")) {
					sum += num;
				} else if (symbol.equals("-")) {
					sum -= num;
				}
			}
		}
		System.out.println(sum);
	}
}
