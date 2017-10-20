import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StudentsByAge {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new LinkedList<>();
		String inputs;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String firstName = input[0];
			String lastName = input[1];
			String num = input[2];
			
			if (Integer.valueOf(num) >= 18 && Integer.valueOf(num) <= 24) {
				result.add(firstName + " " + lastName + " " + num);
			}
		}
		for (String s : result) {
			System.out.println(s);
		}
	}
}
