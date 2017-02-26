
import java.util.ArrayDeque;
import java.util.Scanner;

public class CalculateSequenceWithQueue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.addFirst(n);
        for (int i = 0; i < 50; i++) {
            long current = queue.removeFirst();
            System.out.printf("%d ", current);
            long s1 = current;
            long s2 = s1 + 1;
            long s3 = 2 * s1 + 1;
            long s4 = s1 + 2;
            queue.addLast(s2);
            queue.addLast(s3);
            queue.addLast(s4);
        }
    }
}
