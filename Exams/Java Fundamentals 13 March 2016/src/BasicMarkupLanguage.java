
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkupLanguage {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		int count = 0;
		
		Pattern pattern = Pattern.compile(
				"<\\s*(?<command>[a-zA-Z]+)\\s+(value\\s*=\\s*\"(?<value>[0-9]+)\"\\s+content\\s*=\\s*\"(?<contentV>.*)\"|\\s*(content\\s*=\\s*\"(?<content>.*)\"))");
		
		while (!(input = read.readLine()).equals("<stop/>")) {
			Matcher matcher = pattern.matcher(input);
			StringBuilder result = new StringBuilder();
			
			while (matcher.find()) {
				String command = matcher.group("command");
				String value = matcher.group("value");
				String contentValue = matcher.group("contentV");
				String content = matcher.group("content");
				
				switch (command) {
					case "inverse":
						for (int i = 0; i < content.length(); i++) {
							int charValue = content.charAt(i);
							if (charValue > 64 && charValue < 91) {
								charValue += 32;
							} else if (charValue > 96 && charValue < 123) {
								charValue -= 32;
							}
							result.append((char) charValue);
						}
						count++;
						break;
					case "reverse":
						for (int i = content.length() - 1; i >= 0; i--) {
							result.append(content.charAt(i));
						}
						count++;
						break;
					case "repeat":
						int repeatValue = Integer.valueOf(value);
						result = new StringBuilder(contentValue);
						for (int i = 0; i < repeatValue; i++) {
							count++;
							System.out.printf("%d. %s\n", count, result);
						}
						break;
					default:
						break;
				}
				if (!command.equals("repeat")) {
					System.out.printf("%d. %s\n", count, result);
				}
			}
		}
	}
}
