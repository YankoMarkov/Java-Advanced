import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs;
		StringBuilder input = new StringBuilder();
		while (!(inputs = read.readLine()).equals("END")) {
			input.append(inputs);
		}
		Map<String, String> result = new LinkedHashMap<>();
		
		Pattern pattern = Pattern.compile("(?<name>[A-Z][a-zA-Z]*)[^A-Za-z+]*?(?<phone>[+]*[\\d][-\\d()/.\\s]*[\\d])");
		Matcher matcher = pattern.matcher(input);
		String name = "";
		String phone = "";
		while (matcher.find()) {
			name = matcher.group("name");
			phone = matcher.group("phone");
			phone = phone.replaceAll("[-()/.\\s]+", "");
			result.put(name, phone);
		}
		if (name.equals("") || phone.equals("")) {
			System.out.println("<p>No matches!</p>");
			return;
		}
		int count = 0;
		for (Map.Entry<String, String> res : result.entrySet()) {
			count++;
			if (result.size() == 1) {
				System.out.printf("<ol><li><b>%s:</b> %s</li></ol>", res.getKey(), res.getValue());
				return;
			}
			if (count == 1) {
				System.out.printf("<ol><li><b>%s:</b> %s</li>", res.getKey(), res.getValue());
			} else if (count <= result.size() - 1) {
				System.out.printf("<li><b>%s:</b> %s</li>", res.getKey(), res.getValue());
			} else {
				System.out.printf("<li><b>%s:</b> %s</li></ol>", res.getKey(), res.getValue());
			}
		}
		
	}
}
