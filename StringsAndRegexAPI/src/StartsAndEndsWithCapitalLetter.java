
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsAndEndsWithCapitalLetter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-z]*[A-Z]\\b");
        Matcher matcher = pattern.matcher(txt);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
