import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddVAT {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Double> input = Arrays.stream(read.readLine().split(", ")).map(Double::valueOf).collect(Collectors.toList());
		
		System.out.println("Prices with VAT:");
		input.stream().map(a -> a * 1.2)
				.forEach(res -> System.out.println(String.format("%.2f", res).replace(".", ",")));
	}
}
