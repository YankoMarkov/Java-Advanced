import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] commands = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		int[] array = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (Integer integer : array) {
			stack.push(integer);
		}
		for (int i = 0; i < commands[1]; i++) {
			stack.pop();
		}
		boolean check = false;
		int min = Integer.MAX_VALUE;
		
		for (Integer integer : stack) {
			if (integer == commands[2]) {
				check = true;
			}
			if (integer < min) {
				min = integer;
			}
		}
		if (stack.isEmpty()) {
			System.out.println("0");
		} else if (check) {
			System.out.println("true");
		} else {
			System.out.println(min);
		}
	}
}
