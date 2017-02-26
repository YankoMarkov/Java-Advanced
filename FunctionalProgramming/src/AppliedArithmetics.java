
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        String command;
        while (!(command = scan.nextLine()).equals("end")) {

            switch (command) {
                case "add":
                    executeCommand(input, x -> x + 1);
                    break;
                case "multiply":
                    executeCommand(input, x -> x * 2);
                    break;
                case "subtract":
                    executeCommand(input, x -> x - 1);
                    break;
                case "print":
                    for (int num : input) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }

    private static void executeCommand(int[] num, Function<Integer, Integer> function) {
        for (int i = 0; i < num.length; i++) {
            num[i] = function.apply(num[i]);
        }
    }
}
