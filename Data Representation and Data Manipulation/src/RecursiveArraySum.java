import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		int sum = sumArray(input, input.length - 1);
		System.out.println(sum);
	}
	
	private static int sumArray(int[] input, int num) {
		if (num == 0) {
			return input[num];
		} else {
			return input[num] + sumArray(input, num - 1);
		}
	}
}
