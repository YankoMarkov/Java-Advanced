
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExtractHyperlinks {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String input;

        while (!(input = bfr.readLine()).equals("END")) {
            text.append(input);
        }
        List<String> tags = new ArrayList<>();
        while (true) {
            int openingTag = text.indexOf("<a");
            int closingTag = text.indexOf(">", openingTag + 1);
            if (openingTag == -1 || closingTag == -1) {
                break;
            }
            String tag = text.substring(openingTag, closingTag);
            tags.add(tag);
            text = new StringBuilder(text.substring(closingTag + 1));
        }
        for (String tag : tags) {
            tag = tag.replaceAll("\\s+", " ");
            int hrefIndex = tag.lastIndexOf("href") + 4;
            int equalIndex = tag.indexOf("=", hrefIndex) + 1;
            if (equalIndex == 0) {
                continue;
            }
            int index = equalIndex;
            while (tag.charAt(index) == '\"' ||
                    tag.charAt(index) == '\'' ||
                    tag.charAt(index) == ' ') {
                index++;
            }
            int firstIndex = index;
            char delimiter = tag.charAt(firstIndex - 1);
            if (delimiter != '\"' && delimiter != '\'' && delimiter != ' ') {
                delimiter = ' ';
            }
            while (index < tag.length() && tag.charAt(index) != delimiter) {
                index++;
            }
            int lastIndex = index;
            String link = tag.substring(firstIndex, lastIndex);
            System.out.println(link);
        }

    }
}
