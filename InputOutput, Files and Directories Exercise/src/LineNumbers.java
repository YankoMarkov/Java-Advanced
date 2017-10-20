import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		Path words = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\words.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\output.txt");
		try (BufferedReader bfRead = Files.newBufferedReader(input);
		     BufferedWriter bfWrite = Files.newBufferedWriter(output);
		     BufferedReader bfwords = Files.newBufferedReader(words)) {
			String str = bfRead.readLine();
			int count = 1;
			while (str != null) {
				bfWrite.write(count + ". " + str);
				bfWrite.newLine();
				str = bfRead.readLine();
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
