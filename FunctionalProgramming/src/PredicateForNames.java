
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bfr.readLine());
        String[] text = bfr.readLine().split("\\s+");

        Predicate<String> result = name -> name.length() <= n;

        for (String txt : text) {
            if (result.test(txt)) {
                System.out.println(txt);
            }
        }
    }
}
