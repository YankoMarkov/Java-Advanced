
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bfr.readLine().split("\\s+");
        int a = Integer.valueOf(input[0]);
        double b = Double.valueOf(input[1]);
        double c = Double.valueOf(input[2]);

        String hex = Integer.toHexString(a).toUpperCase();
        String bin = Integer.toBinaryString(a);

        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|", hex, Integer.valueOf(bin), b, c);
    }
}