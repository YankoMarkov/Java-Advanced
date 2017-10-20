import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		
		int index = 0;
		Collections.sort(input);
		for (int i = 0; i < input.size() - 1; i++) {
			if (input.get(i).equals(input.get(i + 1))) {
				index = i + 1;
			} else {
				index = i;
			}
			if (input.get(i + 1) > input.get(i)) {
				break;
			}
		}
		System.out.println(index);
	}
}
