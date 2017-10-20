import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = read.readLine().split("\\s+");
		
		Arrays.stream(inputs)
				.map(String::toUpperCase)
				.forEach(res -> System.out.print(res + " "));
	}
}
