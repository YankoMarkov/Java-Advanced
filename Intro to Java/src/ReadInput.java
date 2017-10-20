import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInput {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		String firstWord = scan.next("\\w+");
		String secondWord = scan.next("\\w+");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.nextLine();
		String thirdWord = scan.nextLine();
		
		int sum = a + b + c;
		System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
	}
}