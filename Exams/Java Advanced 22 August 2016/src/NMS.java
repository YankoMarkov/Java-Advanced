import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NMS {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder inputs = new StringBuilder();
        String input = null;

        while (!(input = read.readLine()).equals("---NMS SEND---")){
            inputs.append(input);
        }

        String delimiter = read.readLine();

        StringBuilder currentWord = new StringBuilder();

        currentWord.append(inputs.charAt(0));

        for (int i = 1; i < inputs.length(); i++) {
            char first = inputs.charAt(i - 1);
            char second = inputs.charAt(i);

            if (Character.toLowerCase(second) >= Character.toLowerCase(first)) {
                currentWord.append(second);
            } else {
                currentWord.append(delimiter).append(second);
            }
        }
        System.out.println(currentWord);
    }
}
