
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] txt = scan.nextLine().split(" ");

        List<Integer> num = Arrays.stream(txt).filter(FilterArray::isNumber).map(Integer::parseInt).collect(Collectors.toList());
        int max = num.stream().mapToInt(Integer::intValue).sum();
        System.out.println(max);

    }

    private static boolean isNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
