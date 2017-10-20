
import java.util.Scanner;

public class HitTheTarget {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20 ; j++) {
                if (i + j == num) {
                    System.out.println(i + " + " + j + " = " + num);
                }
                if (i - j == num) {
                    System.out.println(i + " - " + j + " = " + num);
                }
            }
        }
    }
}
