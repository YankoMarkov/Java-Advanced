
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromSpecifiedLine {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());

        try (BufferedReader bfr = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\02_OddLines\\01_OddLinesIn.txt"))) {
            String txt = null;
            int num = 0;
            while ((txt = bfr.readLine()) != null) {
                num++;
                if (num == n) {
                    System.out.println(txt);
                    num--;
                }
            }
        }
    }
}
