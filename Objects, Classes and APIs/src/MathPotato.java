import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class MathPotato {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = Arrays.stream(read.readLine().split("\\s+")).map(String::new).collect(Collectors.toList());
		int num = Integer.valueOf(read.readLine());
		
		Deque<String> result = new ArrayDeque<>();
		result.addAll(input);
		int number = 1;
		
		while (result.size() > 1) {
			for (int i = 1; i < num; i++) {
				result.add(result.remove());
			}
			if (isPrimeNumber(number)) {
				System.out.printf("Prime %s%n", result.peek());
			} else {
				System.out.printf("Removed %s%n", result.remove());
			}
			number++;
		}
		System.out.printf("Last is %s%n", result.remove());
	}
	
	private static boolean isPrimeNumber(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
