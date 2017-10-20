import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class HotPotato {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = Arrays.stream(read.readLine().split("\\s+")).map(String::new).collect(Collectors.toList());
		int num = Integer.valueOf(read.readLine());
		
		Deque<String> result = new ArrayDeque<>();
		result.addAll(input);
		
		while (result.size() > 1) {
			for (int i = 1; i < num; i++) {
				result.add(result.remove());
			}
			System.out.printf("Removed %s%n", result.remove());
		}
		System.out.printf("Last is %s%n", result.remove());
	}
}
