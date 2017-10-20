import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> result = new ArrayList<>();
		
		Collections.sort(input);
		result.addAll(input.stream()
				.filter(a -> a % 2 == 0)
				.collect(Collectors.toList()));
		result.addAll(input.stream()
				.filter(a -> a % 2 != 0)
				.collect(Collectors.toList()));
		
		System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
	}
}
