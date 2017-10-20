
import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        float b = input.nextFloat();
        float c = input.nextFloat();
        String hexAString = Integer.toHexString(a).toUpperCase();
        String binAString = Integer.toBinaryString(a);
        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|", hexAString, Integer.parseInt(binAString), b, c);
    }
}