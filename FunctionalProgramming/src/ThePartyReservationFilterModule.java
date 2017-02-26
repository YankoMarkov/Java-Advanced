import java.util.*;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.asList(scan.nextLine().split("\\s+"));
        Map<String, Predicate> map = new LinkedHashMap<>();
        String input;
        while (!(input = scan.nextLine()).equals("Print")) {
            String[] inputs = input.split(";");
            String command = inputs[0];
            String modifier = inputs[1];
            String variable = inputs[2];
            Predicate<String> tester = createPredicate(modifier, variable);
            if (command.equals("Add filter")) {
                map.put(modifier + variable, tester);
            }
            if (command.equals("Remove filter")) {
                map.remove(modifier + variable);
            }
        }
        List<String> inviteNames = new ArrayList<>();
        for (String name : names) {
            boolean add = false;
            for (Predicate predicate : map.values()) {
                if (predicate.test(name)) {
                    add = true;
                }
            }
            if (!add) {
                inviteNames.add(name);
            }
        }
        for (String name : inviteNames) {
            System.out.print(name + " ");
        }
    }

    private static Predicate<String> createPredicate(String modifier, String variable) {
        switch (modifier) {
            case "Starts with":
                return string -> string.startsWith(variable);
            case "Ends with":
                return string -> string.endsWith(variable);
            case "Length":
                return string -> string.length() == Integer.valueOf(variable);
            case "Contains":
                return string -> string.contains(variable);
            default:
                return null;
        }
    }
}
