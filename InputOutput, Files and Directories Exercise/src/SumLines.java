import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		try (BufferedReader bfRead = Files.newBufferedReader(input)) {
			String str = bfRead.readLine();
			while (str != null) {
				int sum = 0;
				for (char ch : str.toCharArray()) {
					sum += ch;
				}
				System.out.println(sum);
				str = bfRead.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
