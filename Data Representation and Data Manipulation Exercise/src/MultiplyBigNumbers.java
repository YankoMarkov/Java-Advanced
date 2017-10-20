import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String firstNumber = read.readLine();
		int secondNumber = Integer.valueOf(read.readLine());
		if (secondNumber == 0) {
			System.out.println(0);
			return;
		}
		System.out.println(multiplyNumbers(firstNumber, secondNumber));
	}
	
	private static String multiplyNumbers(String firstNum, int secondNum) {
		StringBuilder result = new StringBuilder();
		int reminder = 0;
		for (int i = firstNum.length() - 1; i >= 0 ; i--) {
			int sum = (Integer.valueOf(String.format("%c", firstNum.charAt(i))) * secondNum) + reminder;
			result = result.append(sum % 10);
			reminder = sum / 10;
		}
		if (reminder != 0) {
			result.append(reminder);
		}
		result.reverse();
		while (result.charAt(0) == '0') {
			result.deleteCharAt(0);
		}
		return result.toString();
	}
}
