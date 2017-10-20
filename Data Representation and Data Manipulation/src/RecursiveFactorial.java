import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		
		System.out.println(factorial(number));
	}
	
	private static long factorial(int number) {
		if (number == 0 || number == 1) {
			return 1;
		} else {
			return number * factorial(number - 1);
		}
	}
}
