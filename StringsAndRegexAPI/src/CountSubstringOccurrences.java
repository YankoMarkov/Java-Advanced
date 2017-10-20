
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine().toLowerCase();
        String word = scan.nextLine();

        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(txt);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
