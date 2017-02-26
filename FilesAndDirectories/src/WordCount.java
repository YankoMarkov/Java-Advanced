import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bfr = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\04_WordCount\\text2.txt"));
             BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\04_WordCount\\aaaaa.txt"));
             BufferedReader words = new BufferedReader(new FileReader("D:\\JAVA\\Java Advanced\\03. Java-Advanced-Files-and-Directories-Exercises\\04_WordCount\\words2.txt"))) {
            String txt;
            Map<String, Integer> map = new HashMap<>();
            String[] word = words.readLine().split("\\s+");
            while ((txt = bfr.readLine()) != null) {
                for (int i = 0; i < word.length; i++) {
                    Pattern pattern = Pattern.compile("\\b" + word[i] + "\\b", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(txt);
                    while (matcher.find()) {
                        if (!map.containsKey(word[i])) {
                            map.put(word[i], 1);
                        } else {
                            map.put(word[i], map.get(word[i]) + 1);
                        }
                    }
                }
            }
            for (Map.Entry<String, Integer> counts : map.entrySet().stream().sorted((a1 ,a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toList())) {
                bfw.write(String.format("%s - %d", counts.getKey(), counts.getValue()));
                bfw.newLine();
            }
        }
    }
}