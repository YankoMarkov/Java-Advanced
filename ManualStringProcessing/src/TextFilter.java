
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] word = bfr.readLine().split(", ");
        String text = bfr.readLine();

        for (int i = 0; i < word.length; i++) {
            String temp = new String(new char[word[i].length()]).replace('\0', '*');
            text = text.replace(word[i], temp);
        }
        System.out.println(text);
    }
}
