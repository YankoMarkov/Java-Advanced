import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MergeTwoFiles {
	
	public static void main(String[] args) {
		Path input1 = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\text1.txt");
		Path input2 = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\text2.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\output.txt");
		try (BufferedReader bfRead1 = Files.newBufferedReader(input1);
		     BufferedReader bfRead2 = Files.newBufferedReader(input2);
		     BufferedWriter bfWrite = Files.newBufferedWriter(output)) {
			String str1 = bfRead1.readLine();
			String str2 = bfRead2.readLine();
			
			addInFile(bfRead1, bfWrite, str1);
			addInFile(bfRead2, bfWrite, str2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void addInFile(BufferedReader bfRead, BufferedWriter bfWrite, String str) throws IOException {
		while (str != null) {
			bfWrite.write(str);
			bfWrite.newLine();
			str = bfRead.readLine();
		}
	}
}
