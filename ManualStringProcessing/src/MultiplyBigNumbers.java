
import java.util.Scanner;

public class MultiplyBigNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstNumber = scan.nextLine();
        int secondNumber = Integer.valueOf(scan.nextLine());
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
