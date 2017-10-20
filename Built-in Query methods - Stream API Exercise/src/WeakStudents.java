import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeakStudents {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			result.add(inputs);
		}
		result.stream()
				.filter(a -> Arrays.stream(a.split(" ")).filter(b -> b.equals("3") || b.equals("2")).toArray().length >1)
				.forEach(res -> System.out.println(res.split(" ")[0] + " " + res.split(" ")[1]));
	}
}
