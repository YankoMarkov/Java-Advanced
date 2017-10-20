import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs;
		List<String> array = new ArrayList<>();
		Pattern firstPattern = Pattern.compile("<(?<toChange>div)(.*?)(?<remove>(id|class)[=\\s]*\"(?<change>[a-z]+)\")");
		Pattern secondPattern = Pattern.compile("</(?<toChange>div)>(?<remove>\\s*((<!--)\\s*(?<change>[a-z]+)\\s*(-->)))");
		
		while (!(inputs = read.readLine()).equals("END")) {
			inputs = matches(inputs, firstPattern);
			array.add(inputs);
		}
		List<String> result = new ArrayList<>();
		
		for (String str : array) {
			str = matches(str, secondPattern);
			result.add(str);
		}
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	private static String matches(String inputs, Pattern pattern) {
		Matcher firstMatcher = pattern.matcher(inputs);
		String toChange = "";
		String remove = "";
		String change = "";
		
		while (firstMatcher.find()) {
			toChange = firstMatcher.group("toChange");
			remove = firstMatcher.group("remove");
			change = firstMatcher.group("change");
		}
		if (!toChange.equals("") && !remove.equals("") && !change.equals("")) {
			inputs = inputs.replaceFirst(remove, "");
			inputs = inputs.replaceAll("\\s+", " ");
			inputs = inputs.replaceFirst(toChange, change);
			int index = inputs.lastIndexOf(">");
			if (inputs.charAt(index - 1) == ' ') {
				inputs = inputs.substring(0, inputs.length() - 2) + ">";
			}
		}
		return inputs;
	}
}
