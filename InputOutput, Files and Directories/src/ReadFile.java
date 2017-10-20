import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	
	public static void main(String[] args) {
		String input = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt";
		try (FileInputStream inputStream = new FileInputStream(input)) {
			int oneByte = inputStream.read();
			while (oneByte >= 0) {
				System.out.printf("%s ", Integer.toBinaryString(oneByte));
				oneByte = inputStream.read();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
