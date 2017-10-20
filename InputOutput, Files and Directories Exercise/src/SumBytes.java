import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		try (BufferedReader bfRead = Files.newBufferedReader(input)) {
			String str = bfRead.readLine();
			long totalSum = 0;
			while (str != null) {
				int sum = 0;
				for (char ch : str.toCharArray()) {
					sum += ch;
				}
				totalSum += sum;
				str = bfRead.readLine();
			}
			System.out.println(totalSum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
