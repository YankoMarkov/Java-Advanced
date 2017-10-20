
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new FileReader("resources/lines"))) {
            String output;
            while ((output = bfr.readLine()) != null) {
                int sum = 0;
                for (int i = 0; i < output.length(); i++) {
                    sum += output.charAt(i);
                }
                System.out.println(sum);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
