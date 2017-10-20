
import java.util.Scanner;

public class CountAllWords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text:");
        String[] str = input.nextLine().split("[\\W]+");
        System.out.println("Number of words: " + str.length);
    }
}
