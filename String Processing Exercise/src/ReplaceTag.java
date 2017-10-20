import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(read.readLine());
		
		while (true){
			String text = read.readLine();
			if(text.equals("END"))
				break;
			input.append("\n");
			input.append(text);
		}
		
		Pattern pattern = Pattern.compile("(<a\\s+href\\s*=\\s*)(.+?)(>)(\\n?.+?)(</a>)");
		Matcher matcher = pattern.matcher(input);
		
		while (matcher.find()){
			String replaceTag = "[URL href=" + matcher.group(2) + "]" + matcher.group(4) + "[/URL]";
			input.replace(matcher.start(), matcher.end(), replaceTag);
			matcher = pattern.matcher(input);
		}
		System.out.println(input);
	}
}
