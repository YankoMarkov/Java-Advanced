import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SortStudents {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new LinkedList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String firstName = input[0];
			String lastName = input[1];
			
			result.add(firstName + " " + lastName);
		}
		result.stream()
				.sorted((a, b) -> {
					if (a.split(" ")[1].compareTo(b.split(" ")[1]) == 0){
						return b.split(" ")[0].compareTo(a.split(" ")[0]);
					}
					return a.split(" ")[1].compareTo(b.split(" ")[1]);
				})
				.forEach(System.out::println);
	}
}
