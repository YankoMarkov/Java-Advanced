
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<StudentSpecialty> specialties = new ArrayList<>();
        List<Collegian> collegians = new ArrayList<>();
        String inputLine = null;
        while (!(inputLine = scan.nextLine()).equals("Students:")) {
            String[] input = inputLine.split("[\\s]+");
            String specialtyName = input[0] + " " + input[1];
            int facultyNumber = Integer.valueOf(input[2]);
            StudentSpecialty specialty = new StudentSpecialty(specialtyName, facultyNumber);
            specialties.add(specialty);
        }
        while (!(inputLine = scan.nextLine()).equals("END")) {
            String[] input = inputLine.split("[\\s]+");
            String name = input[1] + " " + input[2];
            int facultyNumber = Integer.valueOf(input[0]);
            Collegian collegian = new Collegian(name, facultyNumber);
            collegians.add(collegian);
        }
        List<String> joined = new ArrayList<>();
        collegians.stream()
                .flatMap(student -> specialties.stream()
                        .filter(specialty -> {
                            if (specialty.getFacultyNumber() == student.getFacultyNumber()) {
                                joined.add(String.format("%s %d %s", student.getName(), student.getFacultyNumber(), specialty.getSpecialtyName()));
                            }
                            return specialty.getFacultyNumber() == student.getFacultyNumber();
                        }))
                .collect(Collectors.toList());
        joined.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}

class Collegian {
    private String name;
    private int facultyNumber;

    public Collegian(String name, int facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class StudentSpecialty {
    private String specialtyName;
    private int facultyNumber;

    public StudentSpecialty(String specialtyName, int facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
