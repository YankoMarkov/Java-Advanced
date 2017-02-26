
import java.util.Scanner;

public class ReplaceTag {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        String input;
        while (!(input = scan.nextLine()).equals("end")) {
            result.append(input);
        }
        String output = result.toString().replaceAll("<a", "[URL");
        output = output.replaceAll("</a>", "[/URL]");
        System.out.println(output);
    }
}
