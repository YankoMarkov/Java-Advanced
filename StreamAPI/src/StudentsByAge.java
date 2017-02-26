
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {

    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine = null;
            while (!(inputLine = bfr.readLine()).equals("END")) {
                String[] inputs = inputLine.split("[\\s]+");
                String name = inputs[0] + " " + inputs[1];
                Integer age = Integer.valueOf(inputs[2]);
                students.put(name, age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        students.entrySet().stream()
                .filter(s -> s.getValue() >= 18 && s.getValue() <= 24)
                .forEach(s -> System.out.printf("%s %d\n", s.getKey(), s.getValue()));
    }
}
