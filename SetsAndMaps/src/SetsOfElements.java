
import java.util.HashSet;
import java.util.Scanner;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] sets = scan.nextLine().split(" ");
        HashSet<Integer> numberN = new HashSet<>();
        HashSet<Integer> numberM = new HashSet<>();
        int n = Integer.valueOf(sets[0]);
        int m = Integer.valueOf(sets[1]);

        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(scan.nextLine());
            numberN.add(num);
        }
        for (int i = 0; i < m; i++) {
            int num = Integer.valueOf(scan.nextLine());
            numberM.add(num);
        }
        numberN.retainAll(numberM);
        for (Integer num : numberN) {
            System.out.print(num + " ");
        }
    }
}
