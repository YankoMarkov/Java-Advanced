
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsByGroup {

    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String inputs = null;
            while (!(inputs = bfr.readLine()).equals("END")) {
                String[] input = inputs.trim().split("[\\s]+");
                String student = input[0] + " " + input[1];
                Integer group = Integer.valueOf(input[2]);
                students.put(student, group);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        students = students.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toMap(element -> element.getKey(), element -> element.getValue()));
        for (String student : students.keySet()) {
            System.out.println(student);
        }
    }
}
