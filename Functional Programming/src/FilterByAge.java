import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterByAge {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Map<String, Integer> result = new LinkedHashMap<>();
		
		for (int i = 0; i < num; i++) {
			String[] input = read.readLine().split(", ");
			result.put(input[0], Integer.valueOf(input[1]));
		}
		String condition = read.readLine();
		int age = Integer.valueOf(read.readLine());
		String[] resultCondition = read.readLine().split("\\s+");
		
		switch (condition) {
			case "older":
				result = result.entrySet().stream()
						.filter(a -> a.getValue() >= age)
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
				break;
			case "younger":
				result = result.entrySet().stream()
						.filter(a -> a.getValue() < age)
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
				break;
		}
		if (resultCondition.length > 1) {
			for (Map.Entry<String, Integer> res : result.entrySet()) {
				System.out.printf("%s - %s%n", res.getKey(), res.getValue());
			}
		} else if (resultCondition[0].equals("name")) {
			for (String s : result.keySet()) {
				System.out.println(s);
			}
		} else {
			for (Integer integer : result.values()) {
				System.out.println(integer);
			}
		}
	}
}
