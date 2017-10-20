import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstName {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> names = Arrays.asList(read.readLine().split("\\s+"));
		List<Character> letters = Arrays.stream(read.readLine().split("\\s+"))
				.map(a -> a.toLowerCase().charAt(0))
				.collect(Collectors.toList());
		
		Optional<String> result = names.stream()
				.filter(a -> letters.contains(a.toLowerCase().charAt(0)))
				.sorted()
				.findFirst();
		if (result.isPresent()) {
			System.out.println(result.get());
		} else {
			System.out.println("No match");
		}
	}
}

