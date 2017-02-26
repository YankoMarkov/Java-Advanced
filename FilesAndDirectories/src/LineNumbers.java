import java.io.*;

public class LineNumbers {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bfr = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\03_LineNumbers\\01_LinesIn.txt"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\03_LineNumbers\\aaaaa.txt"))) {
            String txt;
            int count = 0;
            while ((txt = bfr.readLine()) != null) {
                count++;
                bfw.write(String.format("%d. %s", count, txt));
                bfw.newLine();
            }
        }
    }
}
