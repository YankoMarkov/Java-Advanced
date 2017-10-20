import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> bound = Arrays.stream(read.readLine().split("\\s+"))
				.map(Integer::valueOf)
				.sorted(Integer::compareTo)
				.collect(Collectors.toList());
		List<Integer> numbers = Arrays.stream(read.readLine().split("\\s+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		
		numbers.stream()
				.filter(a -> a >= bound.get(0) && a <= bound.get(1))
				.forEach(res -> System.out.printf("%s ", res));
	}
}
