import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsResults {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("[\\s,-]+");
		String name = input[0];
		double first = Double.valueOf(input[1]);
		double second = Double.valueOf(input[2]);
		double third = Double.valueOf(input[3]);
		double average = (first + second + third) / 3;
		
		System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
		System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", name, first, second, third, average);
	}
}
