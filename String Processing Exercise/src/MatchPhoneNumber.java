import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Pattern pattern = Pattern.compile("\\+359(\\s|-)2\\1\\b\\d{3}\\b\\1\\b\\d{4}\\b");
		
		while (!(input = read.readLine()).equals("end")) {
			Matcher matcher = pattern.matcher(input);
			
			if (matcher.find()) {
				System.out.println(matcher.group(0));
			}
		}
	}
}
