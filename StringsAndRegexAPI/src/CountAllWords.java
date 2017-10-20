
import java.util.Scanner;

public class CountAllWords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().split("[\\W]+");
        int count = 0;

        for (String s : txt) {
            count++;
        }
        System.out.println(count);
    }
}
