
import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String brackets = input.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            } else {
                if (bracket == '}') {
                    bracket = '{';
                } else if (bracket == ']') {
                    bracket = '[';
                } else {
                    bracket = '(';
                }
                if (stack.empty()) {
                    isBalanced = false;
                    break;
                }
                if (bracket == stack.peek()) {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
