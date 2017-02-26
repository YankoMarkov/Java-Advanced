
import java.util.Scanner;

public class SeriesOfLetters {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().replaceAll("(.)\\1+", "$1");
        System.out.println(input);
    }
}
