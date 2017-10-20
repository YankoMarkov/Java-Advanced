
import java.util.Arrays;
import java.util.Scanner;

public class SortArrayWithStreamAPI {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().split(" ");
        String order = scan.nextLine();

        Arrays.stream(txt).sorted((f1, f2) -> {
            int a = 0;
            if (order.equals("Ascending")) {
                a = f1.compareTo(f2);
            }
            if (order.equals("Descending")) {
                a = f2.compareTo(f1);
            }
            return a;
        }).forEach(s -> System.out.print(s + " "));
    }
}
