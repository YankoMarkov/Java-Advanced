import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumElement {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < num; i++) {
			int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
			
			switch (input[0]) {
				case 1:
					stack.push(input[1]);
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					int max = Integer.MIN_VALUE;
					for (Integer integer : stack) {
						if (integer > max) {
							max = integer;
						}
					}
					System.out.println(max);
					break;
			}
		}
	}
}
