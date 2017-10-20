import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CubicAssault {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		TreeMap<String, Map<String, Long>> result = new TreeMap<>();
		while (!(line = read.readLine()).equals("Count em all")) {
			String[] input = line.split(" -> ");
			String region = input[0];
			String meteor = input[1];
			Long count = Long.parseLong(input[2]);
			
			if (!result.containsKey(region)) {
				result.put(region, new LinkedHashMap<>());
				result.get(region).put("Green", 0L);
				result.get(region).put("Red", 0L);
				result.get(region).put("Black", 0L);
			}
			result.get(region).put(meteor, result.get(region).get(meteor) + count);
			convert(region, meteor, result);
		}
		for (Map.Entry<String, Map<String, Long>> entries : result.entrySet()) {
			String region = entries.getKey();
			Map<String, Long> meteors = entries.getValue();
			for (String meteor : meteors.keySet()) {
				convert(region, meteor, result);
			}
		}
		result.entrySet().stream()
				.sorted((a, b) -> {
					return Integer.compare(a.getKey().length(), b.getKey().length());
				})
				.sorted((a, b) -> {
					return Long.compare(b.getValue().get("Black"), a.getValue().get("Black"));
				})
				.forEach(reg -> {
					System.out.println(reg.getKey());
					reg.getValue().entrySet().stream()
							.sorted((m1, m2) -> m1.getKey().compareTo(m2.getKey()))
							.sorted((a, b) -> {
								return b.getValue().compareTo(a.getValue());
							})
							.forEach(meteor -> {
								System.out.printf("-> %s : %d\n", meteor.getKey(), meteor.getValue());
							});
				});
	}
	
	private static void convert(String region, String meteor, TreeMap<String, Map<String, Long>> result) {
		Long tempCount = result.get(region).get(meteor);
		String tempMeteor = meteor.equals("Green") ? "Red" : "Black";
		if (tempCount >= 1000000 && !meteor.equals("Black")) {
			result.get(region).put(tempMeteor, result.get(region).get(tempMeteor) +
					tempCount / 1000000);
			result.get(region).put(meteor, tempCount % 1000000);
		}
	}
}
