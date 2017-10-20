import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfPredicates {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Integer> input = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
			int index = i;
			if (input.stream().allMatch(a -> index % a == 0)) {
				result.add(index);
			}
		}
		System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
	}
}
