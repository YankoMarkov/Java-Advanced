import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
	
	public static void main(String[] args) {
		String input = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt";
		String output = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\output.txt";
		try (Scanner scanner = new Scanner(new FileInputStream(input));
		     PrintWriter out = new PrintWriter(new FileOutputStream(output))) {
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					out.println(scanner.nextInt());
				}
				scanner.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
