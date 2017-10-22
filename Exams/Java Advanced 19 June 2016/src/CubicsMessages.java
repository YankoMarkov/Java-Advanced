import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String message = null;
		
		while (!(message = read.readLine()).equals("Over!")) {
			int number = Integer.valueOf(read.readLine());
			
			Pattern pattern = Pattern.compile("(?<digits1>\\d+)(?<letters>[a-zA-Z]{" + number + "})");
			String text = "";
			String firstNumber = "";
			Matcher matcher = pattern.matcher(message);
			
			while (matcher.find()) {
				if (matcher.group("letters") != null) {
					if (text.isEmpty()) {
						text = matcher.group("letters");
					}
				}
				if (matcher.group("digits1") != null) {
					if (firstNumber.isEmpty()) {
						firstNumber = matcher.group("digits1");
					}
				}
			}
			int index = firstNumber.length() + text.length();
			String lastPart = message.substring(index);
			StringBuilder secondNumber = new StringBuilder();
			StringBuilder totalText = new StringBuilder();
			boolean isAlphabetic = false;
			
			for (int i = 0; i < lastPart.length(); i++) {
				char temp = lastPart.charAt(i);
				if (Character.isDigit(temp)) {
					secondNumber.append(temp);
				}
				if (Character.isAlphabetic(temp)) {
					isAlphabetic = true;
					break;
				}
			}
			if (isAlphabetic) {
				continue;
			}
			if (!text.isEmpty()) {
				for (int j = 0; j < firstNumber.length(); j++) {
					String index1 = Character.toString(firstNumber.charAt(j));
					int index_1 = Integer.valueOf(index1);
					for (int k = 0; k < text.length(); k++) {
						String index2 = Integer.toString(k);
						int index_2 = text.length() - 1;
						if (index_1 > index_2) {
							totalText = totalText.append(" ");
							break;
						}
						if (index2.equals(index1)) {
							totalText = totalText.append(text.charAt(k));
						}
					}
				}
				if (lastPart.isEmpty()) {
					System.out.printf("%s == %s\n", text, totalText);
					continue;
				}
				for (int j = 0; j < secondNumber.length(); j++) {
					String index1 = Character.toString(secondNumber.charAt(j));
					int index_1 = Integer.valueOf(index1);
					for (int k = 0; k < text.length(); k++) {
						String index2 = Integer.toString(k);
						int index_2 = text.length() - 1;
						if (index_1 > index_2) {
							totalText = totalText.append(" ");
							break;
						}
						if (index2.contains(index1)) {
							totalText = totalText.append(text.charAt(k));
						}
					}
				}
				System.out.printf("%s == %s\n", text, totalText);
			}
		}
	}
}
