import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Map<String, Integer>> result = new TreeMap<>();
		int num = Integer.valueOf(read.readLine());
		
		for (int i = 0; i < num; i++) {
			String[] input = read.readLine().split(" - ");
			String company = input[0].substring(1);
			int amount = Integer.valueOf(input[1]);
			String product = input[2].substring(0, input[2].length() - 1);
			
			if (!result.containsKey(company)) {
				result.put(company, new LinkedHashMap<>());
			}
			if (!result.get(company).containsKey(product)) {
				result.get(company).put(product, amount);
			} else {
				result.get(company).put(product, amount + result.get(company).get(product));
			}
		}
		StringBuilder res = new StringBuilder();
		for (Map.Entry<String, Map<String, Integer>> company : result.entrySet()) {
			res.append(String.format("%s: ", company.getKey()));
			for (Map.Entry<String, Integer> product : company.getValue().entrySet()) {
				res.append(String.format("%s-%d, ", product.getKey(), product.getValue()));
			}
			res.delete(res.length() - 2, res.length()).append("\n");
		}
		System.out.println(res);
	}
}