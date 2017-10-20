import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> result = new LinkedHashMap<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("stop")) {
			int quantity = Integer.valueOf(read.readLine());
			
			if (!result.containsKey(inputs)) {
				result.put(inputs, quantity);
			} else {
				result.put(inputs, result.get(inputs) + quantity);
			}
		}
		for (Map.Entry<String, Integer> res : result.entrySet()) {
			System.out.printf("%s -> %d%n", res.getKey(), res.getValue());
		}
	}
}
