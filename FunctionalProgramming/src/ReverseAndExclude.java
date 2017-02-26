
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int n = Integer.valueOf(scan.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> result = number -> number % n == 0;

        for (int number : numbers) {
            if (!result.test(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
