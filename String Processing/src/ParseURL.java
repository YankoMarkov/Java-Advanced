import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("://");
		if (input.length == 1) {
			System.out.println("Invalid URL");
			return;
		}
		String protocol = input[0];
		int index = input[1].indexOf("/");
		
		if (input.length > 2 || index == -1) {
			System.out.println("Invalid URL");
			return;
		}
		String server = input[1].substring(0, index);
		String resources = input[1].substring(index + 1);
		
		System.out.printf("Protocol = %s%n", protocol);
		System.out.printf("Server = %s%n", server);
		System.out.printf("Resources = %s%n", resources);
	}
}
