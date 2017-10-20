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
		String[] input = read.readLine().split("[\\s\\\\\\\\/\\\\(\\\\)]+");
		
		Pattern pattern = Pattern.compile("\\b[A-Za-z]\\w{2,24}\\b");
		List<String> users = new ArrayList<>();
		
		for (String username : input) {
			Matcher matcher = pattern.matcher(username);
			if (matcher.find()) {
				users.add(username);
			}
		}
		int maxLength = 0;
		String[] longestTwoWords = new String[2];
		
		for (int i = 0; i < users.size() - 1; i++) {
			if (users.get(i).length() + users.get(i + 1).length() > maxLength) {
				maxLength = users.get(i).length() + users.get(i + 1).length();
				longestTwoWords[0] = users.get(i);
				longestTwoWords[1] = users.get(i + 1);
			}
		}
		for (String longestTwoWord : longestTwoWords) {
			System.out.println(longestTwoWord);
		}
	}
}
