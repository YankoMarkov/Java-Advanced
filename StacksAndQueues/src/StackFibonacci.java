package StacksAndQueues;

import java.util.LinkedList;
import java.util.Scanner;

public class StackFibonacci {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Long> stack = new LinkedList<>();
        int n = scan.nextInt();
        stack.push(0L);
        stack.push(1L);

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.peek();
            stack.push(num1);
            stack.push(num1 + num2);
        }
        System.out.printf("%d", stack.peek());
    }

}
