
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        TreeSet<String> camical = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scan.nextLine().split(" ");
            for (String element : elements) {
                camical.add(element);
            }
        }
        for (String name : camical) {
            System.out.print(name + " ");
        }
    }
}
