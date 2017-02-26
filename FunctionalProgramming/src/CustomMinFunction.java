
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.valueOf(input[i]);
        }
        System.out.println(result.apply(numbers));
    }

    private static Function<Integer[], Integer> result = new Function<Integer[], Integer>() {
        @Override
        public Integer apply(Integer[] integers) {
            if (integers.length == 0) {
                return null;
            }
            int min = Integer.MAX_VALUE;
            for (Integer integer : integers) {
                if (min > integer) {
                    min = integer;
                }
            }
            return min;
        }
    };
}
