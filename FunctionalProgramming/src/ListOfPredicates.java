
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        Predicate<Integer> result = number -> {
            for (Integer integer : numbers) {
                if (number % integer != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (result.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
