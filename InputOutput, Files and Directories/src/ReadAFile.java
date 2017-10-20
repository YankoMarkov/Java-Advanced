import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadAFile {
	
	public static void main(String[] args) {
		String input = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt";
		String output = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\output.txt";
		List<Character> symbols = Arrays.asList(',', '.', '!', '?');
		try (FileInputStream inputStream = new FileInputStream(input);
		     FileOutputStream outputStream = new FileOutputStream(output)) {
			int oneByte = inputStream.read();
			while (oneByte >= 0) {
				if (!symbols.contains((char) oneByte)) {
					outputStream.write(oneByte);
				}
				oneByte = inputStream.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
