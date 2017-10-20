import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Map<String, Long>> result = new HashMap<>();
		Pattern pattern = Pattern.compile("^Grow\\s<(?<region>[A-Z][a-z]+)>\\s<(?<color>[a-zA-Z0-9]+)>\\s(?<amount>\\d+)$");
		String inputs = null;
		
		while (!(inputs = read.readLine()).equals("Icarus, Ignite!")) {
			String region = "";
			String color = "";
			long amount = 0;
			Matcher matcher = pattern.matcher(inputs);
			
			while (matcher.find()) {
				region = matcher.group("region");
				color = matcher.group("color");
				amount = Long.valueOf(matcher.group("amount"));
				
				if (!result.containsKey(region)) {
					result.put(region, new HashMap<>());
				}
				if (!result.get(region).containsKey(color)) {
					result.get(region).put(color, amount);
				} else {
					result.get(region).put(color, result.get(region).get(color) + amount);
				}
			}
		}
		result.entrySet().stream()
				.sorted((a1, a2) -> {
					long amount1 = a1.getValue().values().stream().mapToLong(Long::valueOf).sum();
					long amount2 = a2.getValue().values().stream().mapToLong(e -> e).sum();
					if (amount1 == amount2) {
						return a1.getKey().compareTo(a2.getKey());
					}
					return Long.compare(amount2, amount1);
				})
				.forEach(regions -> {
					System.out.println(regions.getKey());
					regions.getValue().entrySet().stream()
							.sorted((a1, a2) -> {
								if (Long.compare(a1.getValue(), a2.getValue()) == 0) {
									return a1.getKey().compareTo(a2.getKey());
								}
								return Long.compare(a1.getValue(), a2.getValue());
							})
							.forEach(colors -> System.out.printf("*--%s | %d\n", colors.getKey(), colors.getValue()));
				});
		
	}
}
