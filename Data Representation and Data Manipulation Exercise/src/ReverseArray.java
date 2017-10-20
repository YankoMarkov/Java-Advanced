import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int firstIndex = 0;
		int lastIndex = input.length - 1;
		
		reverseArray(input, firstIndex, lastIndex);
		
		for (int i : input) {
			System.out.print(i + " ");
		}
		
	}
	
	private static void reverseArray(int[] input, int first, int last) {
		if (first < last) {
			int temp = input[first];
			input[first] = input[last];
			input[last] = temp;
			reverseArray(input, ++first, --last);
		}
	}
}
