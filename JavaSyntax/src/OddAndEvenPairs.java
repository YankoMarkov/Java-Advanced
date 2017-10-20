
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddAndEvenPairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] num = input.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < num.length; i++)  {
            numbers.add(Integer.parseInt(num[i]));
        }
        if (numbers.size() % 2 != 0) {
            System.out.print("Invalid length");
        }
        for (int i = 0; i < numbers.size() ; i += 2) {
            if (numbers.get(i) % 2 == 0 && numbers.get(i + 1) % 2 == 0) {
                System.out.printf("%d, %d -> both are even", numbers.get(i), numbers.get(i + 1));
                System.out.println();
            } else if (numbers.get(i) % 2 != 0 && numbers.get(i + 1) % 2 != 0) {
                System.out.printf("%d, %d -> both are odd", numbers.get(i), numbers.get(i + 1));
                System.out.println();
            } else {
                System.out.printf("%d, %d -> both are different", numbers.get(i), numbers.get(i + 1));
                System.out.println();
            }
        }
    }
}
