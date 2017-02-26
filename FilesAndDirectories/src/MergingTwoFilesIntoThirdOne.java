import java.io.*;

public class MergingTwoFilesIntoThirdOne {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bfr = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\05_MergingFiles\\01_FileOne.txt"));
             BufferedReader bfr1 = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\05_MergingFiles\\01_FileTwo.txt"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\05_MergingFiles\\aaa.txt"))) {
            String txt1;
            String txt2;
            while ((txt1 = bfr.readLine()) != null && (txt2 = bfr1.readLine()) != null) {
                bfw.write(txt1);
                bfw.newLine();
                bfw.write(txt2);
                bfw.newLine();
            }
        }
    }
}
