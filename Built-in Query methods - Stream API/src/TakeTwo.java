import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeTwo {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> inputs = Arrays.stream(read.readLine().split("\\s+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		
		inputs.stream().distinct()
				.filter(a -> a >= 10 && a <= 20)
				.limit(2)
				.forEach(res -> System.out.print(res + " "));
	}
}
