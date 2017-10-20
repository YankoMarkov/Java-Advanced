import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

public class SeriesOfLetters {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs = read.readLine();
		
		Pattern pattern = Pattern.compile("(.)\\1*");
		Matcher matcher = pattern.matcher(inputs);
		
		while (matcher.find()) {
			System.out.print(matcher.group(1));
		}
	}
}
