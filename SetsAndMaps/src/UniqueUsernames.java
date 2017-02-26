
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            names.add(name);
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
