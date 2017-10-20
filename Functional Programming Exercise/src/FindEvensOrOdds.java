import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEvensOrOdds {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		String command = read.readLine();
		List<Integer> result = new ArrayList<>();
		
		for (int i = input[0]; i <= input[1]; i++) {
			result.add(i);
		}
		if (command.equals("even")) {
			result.stream().filter(a -> a % 2 == 0)
			.forEach(res -> System.out.print(res + " "));
		} else {
			result.stream().filter(a -> a % 2 != 0)
			.forEach(res -> System.out.print(res + " "));
		}
	}
}
