import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CombinationsCount {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(read.readLine());
		int k = Integer.valueOf(read.readLine());
		
		printResult(n, k);
	}
	
	private static void printResult(int n, int k) {
		BigInteger result = factorial(n).divide(factorial(k).multiply(factorial(n - k)));
		System.out.println(result);
	}
	
	private static BigInteger factorial(int num) {
		BigInteger number = BigInteger.valueOf(num);
		if (num == 0 || num == 1) {
			return BigInteger.valueOf(1);
		} else {
			return factorial(num - 1).multiply(number);
		}
	}
}
