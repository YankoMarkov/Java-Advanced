
import java.util.Scanner;

public class ConvertFromBase7ToDecimal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String base7Num = input.nextLine();
        System.out.println(Integer.valueOf(base7Num, 7));
    }
}
