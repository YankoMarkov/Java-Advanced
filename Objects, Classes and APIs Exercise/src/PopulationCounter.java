import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PopulationCounter {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Map<String, Long>> result = new HashMap<>();
		Map<String, Long> sort = new HashMap<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("report")) {
			String[] input = inputs.split("[|]");
			String city = input[0];
			String country = input[1];
			long population = Long.valueOf(input[2]);
			
			if (!result.containsKey(country)) {
				result.put(country, new HashMap<>());
				sort.put(country, population);
			} else {
				sort.put(country, sort.get(country) + population);
			}
			if (!result.get(country).containsKey(city)) {
				result.get(country).put(city, population);
			}
		}
		result.entrySet().stream().sorted((a1, a2) -> sort.get(a2.getKey()).compareTo(sort.get(a1.getKey()))).
				forEach(countries -> {
					System.out.printf("%s (total population: %d)\n", countries.getKey(), sort.get(countries.getKey()));
					countries.getValue().entrySet().stream().sorted((b1, b2) -> b2.getValue().compareTo(b1.getValue())).
							forEach(cities -> System.out.printf("=>%s: %d\n", cities.getKey(), cities.getValue()));
				});
	}
}
