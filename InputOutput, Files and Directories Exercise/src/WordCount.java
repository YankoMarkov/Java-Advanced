import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		Path inputWords = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\words.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\output.txt");
		try (BufferedReader bfRead = Files.newBufferedReader(input);
		     BufferedWriter bfWrite = Files.newBufferedWriter(output);
		     BufferedReader bfwords = Files.newBufferedReader(inputWords)) {
			Map<String, Integer> result = new HashMap<>();
			String str = bfRead.readLine();
			String words = bfwords.readLine();
			
			while (words != null) {
				String[] tempWord = words.split("\\s+");
				while (str != null) {
					String[] tempText = str.split("\\s+");
					for (String word : tempWord) {
						for (String text : tempText) {
							if (word.equalsIgnoreCase(text)) {
								if (!result.containsKey(word)) {
									result.put(word, 1);
								} else {
									result.put(word, result.get(word) + 1);
								}
							}
						}
					}
					str = bfRead.readLine();
				}
				words = bfwords.readLine();
			}
			for (Map.Entry<String, Integer> res : result.entrySet()) {
				bfWrite.write(res.getKey() + " - " + res.getValue());
				bfWrite.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
