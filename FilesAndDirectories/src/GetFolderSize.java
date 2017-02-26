
import java.io.File;
import java.io.IOException;

public class GetFolderSize {

    public static void main(String[] args) throws IOException {
        File directory = new File("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\TestFolder");
        long size = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                size += file.length();
            }
        }
        double sizeMegabyte = ((double)size / 1024) / 1024;
        System.out.println(sizeMegabyte);
    }
}
