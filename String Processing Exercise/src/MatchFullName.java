import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\b \\b[A-Z][a-z]+\\b");
		
		while (!(input = read.readLine()).equals("end")) {
			Matcher matcher = pattern.matcher(input);
			
			if (matcher.find()) {
				System.out.println(matcher.group(0));
			}
		}
	}
}
