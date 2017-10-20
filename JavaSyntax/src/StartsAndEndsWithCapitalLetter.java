
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsAndEndsWithCapitalLetter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][A-Za-z]*[A-Z]\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
