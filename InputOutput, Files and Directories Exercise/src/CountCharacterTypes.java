import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
	
	public static void main(String[] args) {
		Path input = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\input.txt");
		Path output = Paths.get("E:\\Java-Advanced-new\\InputOutput, Files and Directories Exercise\\output.txt");
		try (BufferedReader bfRead = Files.newBufferedReader(input);
		     BufferedWriter bfWrite = Files.newBufferedWriter(output)) {
			List<Character> punctuation = Arrays.asList('.', ',', '!', '?');
			List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
			int vowelCount = 0;
			int consonantCount = 0;
			int punctuationCount = 0;
			String str = bfRead.readLine();
			while (str != null) {
				String temp = str.replaceAll("\\s+", "");
				for (int i = 0; i < temp.length(); i++) {
					if (vowel.contains(temp.charAt(i))) {
						vowelCount++;
					} else {
						consonantCount++;
					}
					if (punctuation.contains(temp.charAt(i))) {
						punctuationCount++;
					}
				}
				str = bfRead.readLine();
			}
			bfWrite.write("Vowels: " + vowelCount);
			bfWrite.newLine();
			bfWrite.write("Consonants: " + consonantCount);
			bfWrite.newLine();
			bfWrite.write("Punctuation: " + punctuationCount);
			bfWrite.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
