
import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] command = input.nextLine().split(" ");
        String[] txt = input.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int min = Integer.MAX_VALUE;
        boolean bul = true;
        boolean bul1 = false;
        for (int i = 0; i < command.length; i++) {
            if (command[i] == command[0]) {
                for (int j = 0; j < txt.length; j++) {
                    stack.push(Integer.parseInt(txt[j]));
                }
            }
            if (command[i] == command[1]) {
                int num = Integer.parseInt(command[i]);
                while (num != 0) {
                    stack.pop();
                    num--;
                }
                for (int j = 0; j < stack.size(); j++) {
                    if (min >= stack.peek()) {
                        min = stack.peek();
                        minStack.push(min);
                    }
                }
            }
            if (command[i] == command[2]) {
                int num = Integer.parseInt(command[i]);
                if (stack.contains(num) == bul) {
                    System.out.println(stack.contains(num));
                } else if (stack.contains(num) == bul1) {
                    if (minStack.size() > 0) {
                        System.out.println(minStack.peek());
                    } else {
                        System.out.println("0");
                    }
                }

            }
        }
    }
}
