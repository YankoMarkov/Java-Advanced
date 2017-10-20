import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.util.LinkedList;
		import java.util.List;

public class StudentsByFirstAndLastName {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new LinkedList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String firstName = input[0];
			String lastName = input[1];
			
			if (firstName.compareTo(lastName) < 0) {
				result.add(firstName + " " + lastName);
			}
		}
		for (String s : result) {
			System.out.println(s);
		}
	}
}
