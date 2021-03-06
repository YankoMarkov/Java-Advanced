
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();
        StringBuilder output = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        System.out.println(output);
    }
}
