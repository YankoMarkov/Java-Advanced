import java.io.*;

public class CopyJpgFile {

    public static void main(String[] args) {
        try (BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("resources/i_m_king.jpg"));
             BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("resources/my-copied-picture.jpg"))) {
            int i;
            while ((i = bfis.read()) != -1) {
                bfos.write(i);
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
