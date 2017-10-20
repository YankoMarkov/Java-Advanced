import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
	
	public static void main(String[] args) throws IOException {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories\\input.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories\\output.txt");
		List<String> result = Files.readAllLines(input);
		Collections.sort(result);
		Files.write(output, result);
	}
}
