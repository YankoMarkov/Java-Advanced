
import java.util.Scanner;

public class PrintCharactersTriangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();
        //int array[] = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) (j + 97) + " ");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) (j + 97) + " ");
            }
            System.out.println();
        }
    }
}
