import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String word = read.readLine();
		String text = read.readLine();
		
		Pattern pattern = Pattern.compile("([^!?.]*\\b" + word + "\\b[^!?.]*[!?.])");
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
