import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		int num = Integer.valueOf(read.readLine());
		
		Collections.reverse(input);
		input.stream()
				.filter(a -> a % num != 0)
				.forEach(res -> System.out.print(res + " "));
	}
}
