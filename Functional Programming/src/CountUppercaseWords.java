import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountUppercaseWords {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		
		List<String> result = Arrays.stream(input).filter(a -> a.charAt(0) == a.toUpperCase().charAt(0)).collect(Collectors.toList());
		
		System.out.println(result.size());
		for (String s : result) {
			System.out.println(s);
		}
	}
}
