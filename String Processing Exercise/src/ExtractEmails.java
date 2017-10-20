import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input =read.readLine();
		
		Pattern pattern = Pattern.compile("(?:(?<=\\s)|^)([a-zA-Z0-9]+[\\-\\\\._]?[a-zA-Z0-9]+)@([a-zA-Z]+[\\-]?[a-zA_Z]+)(\\.[a-z]{2,})+");
		Matcher matcher = pattern.matcher(input);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
