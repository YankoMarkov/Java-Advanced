
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] txt = input.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String num : txt) {
            stack.add(Integer.valueOf(num));
        }
        while (stack.size() != 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
