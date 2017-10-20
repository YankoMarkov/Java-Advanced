import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAndSumIntegers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		
		int sum = Arrays.stream(input)
				.filter(a -> isDigits(a))
				.mapToInt(Integer::valueOf)
				.sum();
		System.out.println(sum != 0 ? sum : "No match");
	}
	
	private static boolean isDigits(String str) {
		try {
			Integer.valueOf(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
