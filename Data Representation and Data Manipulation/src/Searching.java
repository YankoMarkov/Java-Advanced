import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Searching {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int num = Integer.valueOf(read.readLine());
		
		//int result = linearSearch(input, num);
		int result = binarySearch(input, num);
		
		printResult(result);
	}
	
	private static void printResult(int result) {
		if (result >= 0) {
			System.out.println(result);
		} else {
			System.out.println("-1");
		}
	}
	
	private static int binarySearch(int[] input, int num) {
		int result = -1;
		int start = 0;
		int end = input.length - 1;
		while (end >= start) {
			int middle = (start + end) / 2;
			if (input[middle] > num) {
				end = middle - 1;
			} else if (input[middle] < num) {
				start = middle + 1;
			} else {
				result = middle;
				break;
			}
		}
		return result;
	}
	
	private static int linearSearch(int[] input, int num) {
		int result = -1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == num) {
				result = i;
				break;
			}
		}
		return result;
	}
}
