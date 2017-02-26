
import java.util.Scanner;

public class UnicodeCharacters {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result = result.append(String.format("\\u00%x", (int)input.charAt(i)));
        }
        System.out.println(result);
    }
}
