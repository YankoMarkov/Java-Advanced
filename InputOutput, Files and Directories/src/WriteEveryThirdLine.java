import java.io.*;

public class WriteEveryThirdLine {
	
	public static void main(String[] args) {
		String input = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt";
		String output = "E:\\Java-Advanced-new\\InputOutput, Files and Directories\\output.txt";
		try (BufferedReader bfRead = new BufferedReader(new FileReader(input));
		     BufferedWriter bfWrite = new BufferedWriter(new FileWriter(output))) {
			String str = bfRead.readLine();
			int count = 1;
			while (str != null) {
				if (count % 3 == 0) {
					bfWrite.write(str);
					bfWrite.newLine();
				}
				count++;
				str = bfRead.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
