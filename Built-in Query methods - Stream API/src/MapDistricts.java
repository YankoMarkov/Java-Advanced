import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MapDistricts {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		int num = Integer.valueOf(read.readLine());
		Map<String, List<Integer>> result = new HashMap<>();
		
		for (String str : input) {
			String[] temp = str.split(":");
			if (!result.containsKey(temp[0])) {
				result.put(temp[0], new ArrayList<>());
			}
			result.get(temp[0]).add(Integer.valueOf(temp[1]));
		}
		result.entrySet().stream()
				.filter(a -> a.getValue().stream().mapToInt(Integer::valueOf).sum() > num)
				.sorted((a, b) -> Integer.compare(
						b.getValue().stream().mapToInt(Integer::valueOf).sum(),
						a.getValue().stream().mapToInt(Integer::valueOf).sum()))
				.forEach(city -> {
					System.out.printf("%s: ", city.getKey());
					city.getValue().stream()
							.sorted(Comparator.reverseOrder())
							.limit(5)
							.forEach(res -> System.out.printf("%s ", res));
					System.out.println();
				});
	}
}
