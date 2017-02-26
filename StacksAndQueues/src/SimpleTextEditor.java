
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        String temp = "";
        LinkedList<String> stack = new LinkedList<>();
        stack.push(temp);

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");
            int num = Integer.valueOf(command[0]);

            switch (num) {
                case 1 :
                    temp += command[1];
                    stack.push(temp);
                    break;
                case 2 :
                    int count = Integer.valueOf(command[1]);
                    temp = temp.substring(0, temp.length() - count);
                    stack.push(temp);
                    break;
                case 3 :
                    int index = Integer.valueOf(command[1]);
                    for (int j = 0; j < temp.length(); j++) {
                        if (index == (j + 1)) {
                            System.out.printf("%c\n", temp.charAt(j));
                        }
                    }
                    break;
                case 4 :
                    stack.pop();
                    temp = stack.peek();
                    break;
            }
        }
    }
}
