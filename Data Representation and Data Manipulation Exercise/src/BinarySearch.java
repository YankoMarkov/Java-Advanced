import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int num = Integer.valueOf(read.readLine());
		
		int result = binarySearch(input, num, 0, input.length - 1);
		
		printResult(result);
	}
	
	private static void printResult(int result) {
		if (result >= 0) {
			System.out.println(result);
		} else {
			System.out.println("-1");
		}
	}
	
	private static int binarySearch(int[] input, int num, int start, int end) {
		int middle = (start + end) / 2;
		if (end < start) {
			return -1;
		}
		if (input[middle] > num) {
			return binarySearch(input, num, start, middle - 1);
		} else if (input[middle] < num) {
			return binarySearch(input, num, middle + 1, end);
		} else {
			return middle;
		}
	}
}
