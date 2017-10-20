import java.io.*;

public class AllCapitals {

    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new FileReader("resources/lines"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("resources/lines1"))) {
            String output;
            String temp;
            while ((temp = bfr.readLine()) != null) {
                output = temp.toUpperCase();
                bfw.write(output);
                bfw.newLine();
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
