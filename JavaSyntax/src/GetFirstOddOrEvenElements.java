
import java.util.Scanner;

public class GetFirstOddOrEvenElements {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        String[] command = input.nextLine().split(" ");
        int[] array = new int[str.length];
        int count = Integer.parseInt(command[1]);
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        switch (command[2]) {
            case "odd" :
                for (int element : array) {
                    if (count == 0) {
                        break;
                    }
                    if (element % 2 != 0) {
                        System.out.print(element + " ");
                        count--;
                    }
                }
                break;
            case "even" :
                for (int element : array) {
                    if (count == 0) {
                        break;
                    }
                    if (element % 2 == 0) {
                        System.out.print(element + " ");
                        count--;
                    }
                }
                break;
            default: break;
        }
    }
}
