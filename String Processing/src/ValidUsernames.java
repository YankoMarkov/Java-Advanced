import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
		import java.util.regex.Pattern;

public class ValidUsernames {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs = null;
		Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
		boolean match = false;
		List<String> matches = new ArrayList<>();
		
		while (!(inputs = read.readLine()).equals("END")) {
			Matcher matcher = pattern.matcher(inputs);
			
			if (matcher.find()) {
				matches.add("valid");
				match = true;
			} else {
				matches.add("invalid");
			}
		}
		if (match) {
			for (String s : matches) {
				System.out.println(s);
			}
		}
	}
}
