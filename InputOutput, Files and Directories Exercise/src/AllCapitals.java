import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\output.txt");
		try(BufferedReader bfRead = Files.newBufferedReader(input);
		    BufferedWriter bfWrite = Files.newBufferedWriter(output)) {
			String str = bfRead.readLine();
			while (str != null) {
				bfWrite.write(str.toUpperCase());
				bfWrite.newLine();
				str = bfRead.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
