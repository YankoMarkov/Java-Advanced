import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		double sum = 0;
		for (String word : input) {
			String number = word.substring(1, word.length() - 1);
			double num = Double.valueOf(number);
			num = firstChar(word.charAt(0), num);
			num = secondChar(word.charAt(word.length() - 1), num);
			sum += num;
		}
		System.out.printf("%.2f", sum);
	}
	
	private static double firstChar(char c, double num) {
		if (c >= 65 && c <= 90) {
			num = num / (c - 64);
		} else {
			num = num * (c - 96);
		}
		return num;
	}
	
	private static double secondChar(char c, double num) {
		if (c >= 65 && c <= 90) {
			num = num - (c - 64);
		} else {
			num = num + (c - 96);
		}
		return num;
	}
}
