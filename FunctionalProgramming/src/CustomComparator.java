import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        Comparator<Integer> comparator = (a1, a2) -> {
            if (a1 % 2 == 0 && a2 % 2 != 0) {
                return -1;
            } else if (a1 % 2 != 0 && a2 % 2 == 0) {
                return 1;
            } else {
                return a1.compareTo(a2);
            }
        };

        Collections.sort(numbers, comparator);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
