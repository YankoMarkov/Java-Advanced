
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        Consumer<String> result = name -> System.out.println(name);

        for (String s : input) {
            result.accept(s);
        }
    }
}
