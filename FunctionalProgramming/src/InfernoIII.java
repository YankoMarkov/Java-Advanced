
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class InfernoIII {
    private static int[] gems;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Predicate> map = new HashMap<>();
        gems = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input;
        while (!(input = scan.nextLine()).equals("Forge")) {
            String[] inputs = input.split(";");
            String command = inputs[0];
            String modifier = inputs[1];
            int variable = Integer.valueOf(inputs[2]);


            Predicate<Integer> tester = predicate(modifier, variable);
            if (command.equals("Exclude")) {
                map.put(modifier + variable, tester);
            }
            if (command.equals("Reverse")) {
                map.remove(modifier + variable);
            }
        }
        for (int i = 0; i < gems.length; i++) {
            boolean print = false;
            for (Predicate predicate : map.values()) {
                if (predicate.test(i)) {
                    print = true;
                }
            }
            if (!print) {
                System.out.printf("%d ", gems[i]);
            }
        }
    }

    private static Predicate<Integer> predicate(String modifier, int variable) {
        switch (modifier) {
            case "Sum Left":
                return x -> (x - 1 < 0 ? 0 : gems[x - 1]) + gems[x] == variable;
            case "Sum Right":
                return x -> (x + 1 >= gems.length ? 0 : gems[x + 1]) + gems[x] == variable;
            case "Sum Left Right":
                return x -> (x - 1 < 0 ? 0 : gems[x - 1]) + gems[x] + (x + 1 >= gems.length ? 0 : gems[x + 1]) == variable;
            default:
                return null;
        }
    }
}
