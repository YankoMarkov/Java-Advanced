
import java.util.Arrays;
import java.util.Scanner;

public class FilterArray1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().split(" ");

        Arrays.stream(txt).filter(s -> s.length() > 3).forEach(s -> System.out.print(s + " "));
    }
}
