
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] command = input.nextLine().split(" ");
        String[] txt = input.nextLine().split(" ");
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> miniQueue = new ArrayDeque<>();
        Queue<Integer> tempQueue = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        boolean bul = true;
        boolean bul1 = false;
        for (int i = 0; i < command.length; i++) {
            if (command[i] == command[0]) {
                for (int j = 0; j < txt.length; j++) {
                    queue.add(Integer.parseInt(txt[j]));
                }
            }
            if (command[i] == command[1]) {
                int num = Integer.parseInt(command[i]);
                while (num != 0) {
                    queue.remove();
                    num--;
                }
                while (queue.size() != 0) {
                    tempQueue.add(queue.peek());
                    int rem = queue.remove();
                    if (min >= rem) {
                        min = rem;
                        miniQueue.add(min);
                    }
                }
                if (miniQueue.size() > 1) {
                    while (miniQueue.size() != 1) {
                        miniQueue.remove();
                    }
                }
            }
            if (command[i] == command[2]) {
                int num = Integer.parseInt(command[i]);
                if (tempQueue.contains(num) == bul) {
                    System.out.println(tempQueue.contains(num));
                } else if (tempQueue.contains(num) == bul1) {
                    if (miniQueue.size() > 0) {
                        System.out.println(miniQueue.peek());
                    } else {
                        System.out.println("0");
                    }
                }
            }
        }
    }
}
