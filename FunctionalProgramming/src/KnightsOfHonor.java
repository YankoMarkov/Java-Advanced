
import java.util.Scanner;
import java.util.function.BiConsumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        BiConsumer<String, String> result = (prefix, name) -> System.out.printf("%s %s\n", prefix, name);

        for (String s : input) {
            result.accept("Sir", s);
        }
    }
}
