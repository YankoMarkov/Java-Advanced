
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine().toLowerCase();
        String word = bfr.readLine().toLowerCase();
        int count = 0;
        int index = input.indexOf(word);

        while (index != -1) {
            count++;
            index = input.indexOf(word, index + 1);
        }
        System.out.println(count);
    }
}
