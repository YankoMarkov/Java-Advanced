
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String input;
        Pattern pattern = Pattern.compile("<a[^>]*href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>");

        while (!(input = scan.nextLine()).equals("END")) {
            text.append(input);
        }
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1));
            } else if (matcher.group(2) != null) {
                System.out.println(matcher.group(2));
            } else if (matcher.group(3) != null) {
                System.out.println(matcher.group(3));
            }
        }
    }
}