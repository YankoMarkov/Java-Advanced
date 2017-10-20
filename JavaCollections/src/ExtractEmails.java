
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("[\\w]+[\\\\.\\-_]*[\\w]+@[A-Za-z]+-*[A-Za-z]\\.[A-Za-z]+\\.*[A-Za-z]+");
        Matcher matcher= pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
