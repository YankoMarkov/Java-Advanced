import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByEmailDomain {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String firstName = input[0];
			String lastName = input[1];
			
			if (inputs.contains("@gmail.com")) {
				result.add(firstName + " " + lastName);
			}
		}
		for (String s : result) {
			System.out.println(s);
		}
	}
}
