import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumNumbers {
	private static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split(", ")).map(Integer::valueOf).collect(Collectors.toList());
		
		input.forEach(a -> sum += a);
		System.out.printf("Count = %s%n", input.size());
		System.out.printf("Sum = %s", sum);
	}
}
