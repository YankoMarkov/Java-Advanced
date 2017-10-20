import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ProductOfNumbersNtoM {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		int a = Integer.valueOf(input[0]);
		int b = Integer.valueOf(input[1]);
		BigInteger res = BigInteger.valueOf(a);
		
		for (int i = a + 1; i <= b; i++) {
			BigInteger index = BigInteger.valueOf(i);
			res = res.multiply(index);
		}
		System.out.printf("product[%d..%d] = %d", a, b, res);
	}
}
