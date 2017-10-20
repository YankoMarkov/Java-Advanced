import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LegendaryFarming {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> special = new HashMap<>();
		Map<String, Integer> junk = new TreeMap<>();
		
		special.put("shards", 0);
		special.put("fragments", 0);
		special.put("motes", 0);
		
		String legendary = null;
		
		while (legendary == null) {
			String[] inputs = read.readLine().split("\\s+");
			for (int i = 0; i < inputs.length; i += 2) {
				int quantity = Integer.valueOf(inputs[i]);
				String material = inputs[i + 1].toLowerCase();
				if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
					special.put(material, special.get(material) + quantity);
					if (special.get(material) >= 250) {
						special.put(material, special.get(material) - 250);
						switch (material) {
							case "shards":
								legendary = "Shadowmourne";
								break;
							case "fragments":
								legendary = "Valanyr";
								break;
							case "motes":
								legendary = "Dragonwrath";
								break;
						}
					}
					if (legendary != null) {
						break;
					}
				} else {
					if (!junk.containsKey(material)) {
						junk.put(material, quantity);
					} else {
						junk.put(material, junk.get(material) + quantity);
					}
				}
			}
		}
		System.out.printf("%s obtained!%n", legendary);
		special.entrySet().stream()
				.sorted((a1, a2) -> {
					if (a1.getKey().equals(a2.getKey())) {
						return a1.getKey().compareTo(a2.getKey());
					}
					return a2.getValue().compareTo(a1.getValue());
				})
				.forEach(str -> System.out.printf("%s: %d%n", str.getKey(), str.getValue()));
		junk.entrySet().stream()
				.forEach(str -> System.out.printf("%s: %d%n", str.getKey(), str.getValue()));
	}
}
