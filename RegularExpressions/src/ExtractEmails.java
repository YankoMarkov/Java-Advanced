
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();

        Pattern pattern = Pattern.compile("(?:(?<=\\s)|^)([a-zA-Z0-9]+[\\-\\\\._]?[a-zA-Z0-9]+)@([a-zA-Z]+[\\-]?[a-zA_Z]+)(\\.[a-z]{2,})+");
        Matcher matcher = pattern.matcher(txt);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
