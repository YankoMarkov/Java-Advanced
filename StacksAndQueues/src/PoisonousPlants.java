
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] plants = new int[n];
        for (int i = 0; i < plants.length; i++) {
            plants[i] = scan.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[plants.length];
        stack.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (stack.size() > 0 && plants[stack.peek()] >= plants[x]) {
                maxDays = Integer.max(days[stack.pop()], maxDays);
            }
            if (stack.size() > 0) {
                days[x] = maxDays + 1;
            }
            stack.push(x);
        }
        System.out.printf("%d%n", Arrays.stream(days).max().getAsInt());
    }
}