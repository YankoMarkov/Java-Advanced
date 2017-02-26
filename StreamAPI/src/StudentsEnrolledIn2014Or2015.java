import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentsEnrolledIn2014Or2015 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String inputLine = null;
        Pattern pattern = Pattern.compile("([0-9]+)[\\s]+([0-9\\s]+)");
        while (!(inputLine = scan.nextLine()).equals("END")) {
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                String student = matcher.group(1);
                String[] mark = matcher.group(2).split("[\\s]+");
                List<Integer> marks = Arrays.stream(mark).map(Integer::valueOf).collect(Collectors.toList());
                students.put(student, marks);
            }
        }

        students = students.entrySet().stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (List<Integer> integers : students.values()) {
            for (Integer integer : integers) {
                System.out.printf("%s ", integer);
            }
            System.out.println();
        }
    }
}
