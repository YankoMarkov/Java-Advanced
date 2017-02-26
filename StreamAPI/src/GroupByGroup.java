
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroupByGroup {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String inputLine = null;
        while (!(inputLine = scan.nextLine()).equals("END")) {
            String[] input = inputLine.split("[\\s]+");
            String name = input[0] + " " + input[1];
            int group = Integer.valueOf(input[2]);
            Student student = new Student();
            student.setName(name);
            student.setGroup(group);
            students.add(student);
        }
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup))
                .forEach((group, student) -> {
                    System.out.printf("%d - ", group);
                    System.out.println(String.join(" ", student.toString().replaceAll("[\\[\\]]", "")));
                });
    }
}
