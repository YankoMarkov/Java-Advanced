
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();
        Pattern pattern = Pattern.compile("<p>(.+?)</p>");
        Matcher matcher = pattern.matcher(input);
        StringBuilder extractedText = new StringBuilder();

        while (matcher.find()) {
            extractedText = extractedText.append(matcher.group(1));
        }
        String replacedText = extractedText.toString().replaceAll("[^a-z0-9]+", " ");
        StringBuilder result = new StringBuilder();

        for (Character characters : replacedText.toCharArray()) {
            if (characters.compareTo('a') >= 0 && characters.compareTo('m') <= 0) {
                Character toAppend = (char)(characters + 13);
                result = result.append(toAppend);
            } else if (characters.compareTo('n') >= 0 && characters.compareTo('z') <= 0) {
                Character toAppend = (char)(characters - 13);
                result = result.append(toAppend);
            } else {
                result = result.append(characters);
            }
        }
        System.out.println(result.toString().replaceAll("\\s+", " "));
    }
}
