import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split(", ")).map(Integer::valueOf).collect(Collectors.toList());
		
		input.removeIf(a -> a % 2 != 0);
		System.out.println(Arrays.toString(input.toArray()).replaceAll("[\\[\\]]", ""));
		input.sort(Integer::compareTo);
		System.out.println(Arrays.toString(input.toArray()).replaceAll("[\\[\\]]", ""));
	}
}
