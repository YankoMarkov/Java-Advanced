
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers separate with space:");
        String[] str = input.nextLine().split(" ");
        int[] array = new int[str.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(array[i]);
            while (i < array.length - 1 && array[i + 1] > array[i]) {
                temp.add(array[i + 1]);
                i++;
            }
            System.out.println(temp);
            if (temp.size() > sequence.size()) {
                sequence.clear();
                sequence.addAll(temp);
            }
        }
        System.out.println("Longest: " + sequence);
    }
}
