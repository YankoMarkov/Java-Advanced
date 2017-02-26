
import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger first = new BigInteger(scan.nextLine());
        BigInteger second = new BigInteger(scan.nextLine());

        BigInteger result = first.add(second);
        System.out.println(result);
    }
}
