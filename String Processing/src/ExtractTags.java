import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs = null;
		
		Pattern pattern = Pattern.compile("<.+?>");
		while (!(inputs = read.readLine()).equals("END")) {
			Matcher matcher = pattern.matcher(inputs);
			
			while (matcher.find()) {
				System.out.println(matcher.group(0));
			}
		}
	}
}
