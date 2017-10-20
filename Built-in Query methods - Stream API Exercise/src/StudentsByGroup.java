import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByGroup {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String name = input[0] + " " + input[1];
			String num = input[2];
			
			if ("2".equals(num)) {
				result.add(name);
			}
		}
		Collections.sort(result);
		for (String s : result) {
			System.out.println(s);
		}
	}
}
