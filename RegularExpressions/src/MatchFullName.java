
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        while (!(input = scan.nextLine()).equals("end")) {
            Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\b\\s+\\b[A-Z][a-z]+\\b");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String result = matcher.group().replaceAll("\\s+", " ");
                System.out.println(result);
            }
        }
    }
}
