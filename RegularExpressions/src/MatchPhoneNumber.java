
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        while (!(input = scan.nextLine()).equals("end")) {
            Pattern pattern = Pattern.compile("\\+359(\\s|-)2\\1\\b\\d{3}\\b\\1\\b\\d{4}\\b");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
