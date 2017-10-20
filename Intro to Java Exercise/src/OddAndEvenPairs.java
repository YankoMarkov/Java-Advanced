import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddAndEvenPairs {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		
		if (input.length % 2 != 0) {
			System.out.println("invalid length");
			return;
		}
		for (int i = 0; i < input.length; i+=2) {
			int first = Integer.valueOf(input[i]);
			int second = Integer.valueOf(input[i + 1]);
			if (first % 2 == 0 && second % 2 == 0) {
				System.out.printf("%s, %s -> both are even%n", first, second);
			} else if (first % 2 != 0 && second % 2 != 0){
				System.out.printf("%s, %s -> both are odd%n", first, second);
			} else {
				System.out.printf("%s, %s -> different%n", first, second);
			}
		}
	}
}
