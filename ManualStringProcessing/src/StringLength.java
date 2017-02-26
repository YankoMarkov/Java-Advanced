
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(bfr.readLine());

        if (sb.length() > 20) {
            String out = sb.substring(0, 20);
            System.out.println(out);
        } else {
            for (int i = sb.length(); i < 20; i++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}

