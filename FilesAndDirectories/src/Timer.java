import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Timer {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bfr1 = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\TestFolder\\1. Java-Advanced-Stacks-and-Queues.pptx"));
             BufferedReader bfr2 = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\TestFolder\\1. Java-Advanced-Stacks-and-Queues-Lab.docx"))) {
            long startTime1 = System.nanoTime();
            while (bfr1.readLine() != null);
            long endTime1 = System.nanoTime();
            long result1 = endTime1 - startTime1;

            long startTime2 = System.nanoTime();
            while (bfr2.readLine() != null);
            long endTime2 = System.nanoTime();
            long result2 = endTime2 - startTime2;

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result1 > result2);
        }
    }
}
