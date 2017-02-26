
import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstNumber = scan.nextLine();
        String secondNumber = scan.nextLine();
        System.out.println(sumNumbers(firstNumber, secondNumber));
    }

    private static String sumNumbers(String firsNum, String secondNum) {
        StringBuilder result = new StringBuilder();
        int difference = Math.abs(firsNum.length() - secondNum.length());
        if (firsNum.length() < secondNum.length()) {
            String toAppend = new String(new char[difference]).replace('\0', '0');
            firsNum = toAppend + firsNum;
        } else if (secondNum.length() < firsNum.length()) {
            String toAppend = new String(new char[difference]).replace('\0', '0');
            secondNum = toAppend + secondNum;
        }
        int reminder = 0;
        int length = Math.min(firsNum.length(), secondNum.length());
        for (int i = length - 1; i >= 0 ; i--) {
            int sum = Integer.valueOf(String.format("%c", firsNum.charAt(i))) + Integer.valueOf(String.format("%c", secondNum.charAt(i))) + reminder;
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
