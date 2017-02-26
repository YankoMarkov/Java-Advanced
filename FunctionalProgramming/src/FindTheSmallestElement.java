
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> result = x -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] <= min) {
                    min = x[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(result.apply(numbers));
    }
}