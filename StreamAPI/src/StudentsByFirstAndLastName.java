
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {

    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String input = null;
            while (!(input = bfr.readLine()).equals("END")) {
                students.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        students.stream()
                .filter(student -> {
                    String[] inputs = student.split("[\\s]+");
                    String firstName = inputs[0];
                    String secondName = inputs[1];
                    return firstName.compareTo(secondName) < 0;
                }).forEach(System.out::println);

    }
}
