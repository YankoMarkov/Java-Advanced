
import java.util.Scanner;

public class CountSpecifiedWord {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().toLowerCase().split("[\\W]+");
        String word = scan.nextLine();
        int count = 0;

        for (int i = 0; i <txt.length ; i++) {
            if (txt[i].equals(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
