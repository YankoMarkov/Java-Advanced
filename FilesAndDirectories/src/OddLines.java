import java.io.*;

public class OddLines {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bfr = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\02_OddLines\\02_OddLinesIn.txt"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\02_OddLines\\aaaaaaa.txt"))) {
            String txt = null;
            int count = -1;
            while ((txt = bfr.readLine()) != null) {
                count++;
                if (count % 2 == 1) {
                    bfw.write(txt);
                    bfw.newLine();
                }
            }
        }
    }
}
