
import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger first = new BigInteger(scan.nextLine());
        BigInteger second = new BigInteger(scan.nextLine());

        BigInteger result = first.multiply(second);
        System.out.println(result);
    }
}
