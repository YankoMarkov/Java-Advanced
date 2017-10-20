import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greeting {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String firstName = read.readLine();
		String secondName = read.readLine();
		
		if (firstName.isEmpty()) {
			firstName = "*****";
		}
		if (secondName.isEmpty()) {
			secondName = "*****";
		}
		
		System.out.printf("Hello, %s %s!", firstName, secondName);
	}
}
