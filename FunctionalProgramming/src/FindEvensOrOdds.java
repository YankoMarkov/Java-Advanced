
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNum = scan.nextLine().split("\\s+");
        String inputCommand = scan.nextLine();
        int min = Integer.valueOf(inputNum[0]);
        int max = Integer.valueOf(inputNum[1]);
        List<Integer> numbers = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        Predicate<Integer> result = number -> number % 2 == 0;

        switch (inputCommand) {
            case "even":
                for (Integer number : numbers) {
                    if (result.test(number)) {
                        System.out.print(number + " ");
                    }
                }
                break;
            case "odd":
                for (Integer number : numbers) {
                    if (!result.test(number)) {
                        System.out.print(number + " ");
                    }
                }
                break;
            default:
                break;
        }
    }
}
