import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String key = read.readLine();
		String text = read.readLine();
		
		String startKey = findStartKey(key);
		String endKey = findEndKey(key);
		double sum = findInText(startKey, endKey, text);
		
		if (startKey.equals("") || endKey.equals("")) {
			System.out.println("<p>A key is missing</p>");
		} else if (sum > 0) {
			if (sum % 1 == 0) {
				System.out.printf("<p>The total value is: <em>%.0f</em></p>", sum);
			} else {
				System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
			}
		} else {
			System.out.println("<p>The total value is: <em>nothing</em></p>");
		}
	}
	
	private static double findInText(String startKey, String endKey, String text) {
		Pattern pattern = Pattern.compile(startKey + "([\\d.]+)" + endKey);
		Matcher matcher = pattern.matcher(text);
		double sum = 0;
		
		while (matcher.find()) {
			sum += Double.valueOf(matcher.group(1));
		}
		return sum;
	}
	
	private static String findEndKey(String key) {
		Pattern pattern = Pattern.compile("\\d([a-zA-Z_]+)$");
		Matcher matcher = pattern.matcher(key);
		String endKey = "";
		
		if (matcher.find()) {
			endKey = matcher.group(1);
		}
		return endKey;
	}
	
	private static String findStartKey(String key) {
		Pattern pattern = Pattern.compile("^([a-zA-Z_]+)\\d");
		Matcher matcher = pattern.matcher(key);
		String startKey = "";
		
		if (matcher.find()) {
			startKey = matcher.group(1);
		}
		return startKey;
	}
}
