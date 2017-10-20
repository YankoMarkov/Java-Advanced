
import java.util.Scanner;

public class ConvertFromDecimalSystemToBase7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int decNum = input.nextInt();
        System.out.println(Integer.toString(decNum, 7));
    }
}
