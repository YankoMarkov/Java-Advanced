import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		String startTags = "<upcase>";
		String endTags = "</upcase>";
		
		while (true) {
			int startIndex = input.indexOf(startTags);
			int endIndex = input.indexOf(endTags);
			if (startIndex == -1) {
				break;
			}
			String strToReplace = input.substring(startIndex, endIndex + endTags.length());
			String strToUpper = input.substring(startIndex + startTags.length(), endIndex).toUpperCase();
			input = input.replaceFirst(strToReplace, strToUpper);
		}
		System.out.println(input);
	}
}
