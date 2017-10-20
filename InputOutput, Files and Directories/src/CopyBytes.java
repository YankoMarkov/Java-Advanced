import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	
	public static void main(String[] args) {
		String input = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt";
		String output = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\output.txt";
		try (FileInputStream inputStream = new FileInputStream(input);
		     FileOutputStream outputStream = new FileOutputStream(output)) {
			int oneByte = inputStream.read();
			while (oneByte >= 0) {
				if (oneByte == 10 || oneByte == 32) {
					outputStream.write(oneByte);
				} else {
					String digit = String.valueOf(oneByte);
					for (int i = 0; i < digit.length(); i++) {
						outputStream.write(digit.charAt(i));
					}
				}
				oneByte = inputStream.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

