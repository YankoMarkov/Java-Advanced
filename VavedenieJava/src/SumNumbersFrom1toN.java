
import java.util.Scanner;

public class SumNumbersFrom1toN {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.print(i + " + ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
