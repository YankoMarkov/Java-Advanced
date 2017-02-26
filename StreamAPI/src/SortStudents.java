
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortStudents {

    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine = null;
            while (!(inputLine = bfr.readLine()).equals("END")) {
                students.add(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        students.stream()
                .sorted((s1, s2) -> {
                    String[] input1 = s1.split("\\s+");
                    String firstName1 = input1[0];
                    String lastName1 = input1[1];
                    String[] input2 = s2.split("\\s+");
                    String firstName2 = input2[0];
                    String lastName2 = input2[1];
                    if (lastName1.equals(lastName2)) {
                        return firstName2.compareTo(firstName1);
                    }
                    return lastName1.compareTo(lastName2);
                }).forEach(System.out::println);
    }
}
