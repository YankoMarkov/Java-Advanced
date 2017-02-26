
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateParty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.asList(scan.nextLine().split("\\s+"));
        String input;
        while (!(input = scan.nextLine()).equals("Party!")) {
            String[] inputs = input.split("\\s+");
            String command = inputs[0];
            String modifier = inputs[1];
            String variable = inputs[2];
            Predicate<String> tester = createPredicate(modifier, variable);
            if (command.equals("Double")) {
                names = doubleModifier(names, tester);
            }
            if (command.equals("Remove")) {
                names = removeModifier(names, tester);
            }
        }
        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }

    private static Predicate<String> createPredicate(String modifier, String variable) {
        Predicate<String> tester;
        switch (modifier) {
            case "StartsWith":
                return tester = string -> string.startsWith(variable);
            case "EndsWith":
                return tester = string -> string.endsWith(variable);
            case "Length":
                return tester = string -> string.length() == Integer.valueOf(variable);
            default:
                return null;
        }
    }

    private static List<String> removeModifier(List<String> names, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (!predicate.test(name)) {
                result.add(name);
            }
        }
        return result;
    }

    private static List<String> doubleModifier(List<String> names, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (predicate.test(name)) {
                result.add(name);
            }
            result.add(name);
        }
        return result;
    }
}
