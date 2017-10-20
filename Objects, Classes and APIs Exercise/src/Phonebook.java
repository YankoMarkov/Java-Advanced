import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> result = new HashMap<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("search")) {
			String[] input = inputs.split("-");
			String name = input[0];
			String phoneNum = input[1];
			
			if (!result.containsKey(name)) {
				result.put(name, phoneNum);
			} else {
				result.put(name, phoneNum);
			}
		}
		while (!(inputs = read.readLine()).equals("stop")) {
			int count = 0;
			for (String s : result.keySet()) {
				if (inputs.equals(s)) {
					System.out.printf("%s -> %s%n", inputs, result.get(s));
					count++;
				}
			}
			if (count == 0) {
				System.out.printf("Contact %s does not exist.%n", inputs);
			}
		}
	}
}
