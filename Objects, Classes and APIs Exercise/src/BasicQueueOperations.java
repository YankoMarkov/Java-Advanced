import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BasicQueueOperations {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] commands = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int[] array = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		for (Integer integer : array) {
			queue.add(integer);
		}
		for (int i = 0; i < commands[1]; i++) {
			queue.remove();
		}
		boolean check = false;
		int min = Integer.MAX_VALUE;
		
		for (Integer integer : queue) {
			if (integer == commands[2]) {
				check = true;
			}
			if (integer < min) {
				min = integer;
			}
		}
		if (queue.isEmpty()) {
			System.out.println("0");
		} else if (check) {
			System.out.println("true");
		} else {
			System.out.println(min);
		}
	}
}
