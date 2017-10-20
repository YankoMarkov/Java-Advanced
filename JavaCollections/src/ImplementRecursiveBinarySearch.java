
import java.util.Arrays;
import java.util.Scanner;

public class ImplementRecursiveBinarySearch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter num: ");
        int num = input.nextInt();
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));
        int lower = 0;
        int upper = array.length;
        int position;
        position = (lower + upper) / 2;
        while ((array[position] != num) && (lower <= upper)) {
            if (num < lower || num > upper) {
                break;
            } else if (array[position] > num) {
                upper = position - 1;
            } else {
                lower = position + 1;
            }
            position = (lower + upper) / 2;
        }
        if (num < lower || num > upper) {
            System.out.println("-1");
        } else {
            System.out.println(position);
        }
    }
}
