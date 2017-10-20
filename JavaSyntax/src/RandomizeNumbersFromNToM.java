
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RandomizeNumbersFromNToM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int biggerNum = 0;
        int smallerNum = 0;
        if (n < m) {
            biggerNum = m;
            smallerNum = n;
        } else if (n > m) {
            biggerNum = n;
            smallerNum = m;
        }
        List<Integer> num = new ArrayList<>();
        for (int i = smallerNum; i <= biggerNum; i++) {
            num.add(i);
        }
        Collections.shuffle(num);
        for (int number : num) {
            if (n < m || n > m) {
                System.out.print(number + " ");
            } else {
                System.out.println(n);
            }
        }
    }
}
