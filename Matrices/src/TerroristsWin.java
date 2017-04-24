import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerroristsWin {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputs = new StringBuilder(read.readLine());

        int start = inputs.indexOf("|");
        int end = inputs.indexOf("|", start + 1);

        while (end != -1) {
            String bomb = inputs.substring(start + 1, end);

            int sum = 0;
            for (int i = 0; i < bomb.length(); i++) {
                char temp = bomb.charAt(i);
                sum += temp;
            }
            int bombPower = sum % 10;
            int startIndex = Math.max(0, start - bombPower);
            int endIndex = Math.min(inputs.length() - 1, end + bombPower);

            while (startIndex <= endIndex) {
                inputs.setCharAt(startIndex, '.');
                startIndex++;
            }
            start = inputs.indexOf("|", start + 1);
            end = inputs.indexOf("|", start + 1);
        }
        System.out.println(inputs);
    }
}
