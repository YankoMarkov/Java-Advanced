package StringsAndRegexAPI;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();

        Pattern pattern = Pattern.compile("[\\w]+[\\\\.\\-_]*[\\w]+@[A-Za-z]+-*[A-Za-z]\\.[A-Za-z]+\\.*[A-Za-z]+");
        Matcher matcher = pattern.matcher(txt);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
