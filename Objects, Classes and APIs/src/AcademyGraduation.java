import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Map<String, List<Double>> result = new TreeMap<>();
		
		for (int i = 0; i < num; i++) {
			String name = read.readLine();
			List<Double> scores = Arrays.stream(read.readLine().split("\\s+")).map(Double::valueOf).collect(Collectors.toList());
			
			if (!result.containsKey(name)) {
				result.put(name, scores);
			}
		}
		for (Map.Entry<String, List<Double>> res : result.entrySet()) {
			double sum = 0;
			for (int i = 0; i < res.getValue().size(); i++) {
				sum += res.getValue().get(i);
			}
			double resSum = sum / res.getValue().size();
			System.out.printf("%s is graduated with %s%n", res.getKey(), resSum);
		}
	}
}
