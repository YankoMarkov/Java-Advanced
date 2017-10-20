import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateForNames {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<String> input = Arrays.stream(read.readLine().split("\\s+")).map(String::new).collect(Collectors.toList());
		
		input.stream()
				.filter(a -> a.length() <= num)
				.forEach(System.out::println);
	}
}
