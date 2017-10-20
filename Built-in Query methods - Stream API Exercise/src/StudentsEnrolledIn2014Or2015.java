import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsEnrolledIn2014Or2015 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			result.add(inputs);
		}
		result.stream()
				.filter(a -> a.split(" ")[0].endsWith("14") || a.split(" ")[0].endsWith("15"))
				.forEach(res -> System.out.println(res.split("\\d{3,} ")[1]));
	}
}
