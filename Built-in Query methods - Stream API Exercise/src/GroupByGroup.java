import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupByGroup {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, List<String>> result = new TreeMap<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String firstName = input[0];
			String lastName = input[1];
			int num = Integer.valueOf(input[2]);
			
			if (!result.containsKey(num)) {
				result.put(num, new ArrayList<>());
			}
			result.get(num).add(firstName + " " + lastName);
		}
		result.entrySet().stream()
				.forEach(res -> System.out.println(res.getKey() + " - " + res.getValue().toString().replaceAll("[\\[\\]]", "")));
	}
}
