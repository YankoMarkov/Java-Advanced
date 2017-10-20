
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortArrayWithStreamAPI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers separate with space:");
        String[] numbers = input.nextLine().split(" ");
        System.out.println("Enter ascending or descending");
        String word = input.nextLine();
        String ascending = "ascending";
        String descending = "descending";
        List<Integer> num = new ArrayList<>();
        for (String number : numbers) {
            num.add(Integer.parseInt(number));
        }
        if (word.equals(ascending)) {
            num.stream().sorted().forEach(i -> System.out.print(i + " "));
        } else if (word.equals(descending)) {
            num.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + " "));
        }
    }
}
